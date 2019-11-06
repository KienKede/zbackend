package com.zitro.zbackend.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.zitro.zbackend.exceptions.DeletedUserException;
import com.zitro.zbackend.persistence.domain.Deposit;
import com.zitro.zbackend.persistence.domain.Player;
import com.zitro.zbackend.persistence.repository.jpa.DepositJpaDao;
import com.zitro.zbackend.service.interfaces.DepositServiceInterface;
import com.zitro.zbackend.tools.mapping.domain.DepositMapping;
import com.zitro.zbackend.tools.mapping.domain.PlayerMapping;
import com.zitro.zbackend.web.dto.deposit.BasicDepositDTO;
import com.zitro.zbackend.web.dto.deposit.CreationDepositDTO;
import com.zitro.zbackend.web.dto.deposit.DepositDTO;
import com.zitro.zcommon.service.IdAbstractService;

@Service
public class DepositService extends IdAbstractService<CreationDepositDTO, BasicDepositDTO, DepositDTO, Deposit> implements DepositServiceInterface {

	private DepositJpaDao depositDAO;
	
	private PlayerService playerService;
	
	public DepositService (DepositJpaDao depositDAO, @Lazy PlayerService playerService) {
		super();
		this.depositDAO = depositDAO;
		this.playerService = playerService;
	}
	
	@Override
	protected DepositJpaDao getDao() {
		return depositDAO;
	}

	@Override
	protected DepositMapping getMapping() {
		return DepositMapping.getMapping();
	}

	public List<DepositDTO> getAllDepositsByPlayerUUID (UUID uuid) {
		return getMapping().entityToDtoList(depositDAO.findAllByPlayerUUID(uuid));
	}

	@Transactional(rollbackFor = DeletedUserException.class)
	public DepositDTO createDeposit(CreationDepositDTO depositDTO) throws DeletedUserException {
		Preconditions.checkNotNull(depositDTO);
		
		Player player = PlayerMapping.getMapping().normalDtoToEntity(playerService.findOne(depositDTO.getPlayer()));
		
		Preconditions.checkNotNull(player);
		
		if(player.isDeleted()) {
			throw new DeletedUserException("The user " + player.getUUID() + " is deleted!");
		}
		
		player.setBalance(player.getBalance()+depositDTO.getAmount());
		
		playerService.update(player);
		
		Deposit deposit = new Deposit();
		
		deposit.setAmount(depositDTO.getAmount());
		deposit.setPlayer(player);
		deposit.setDeposited((new Date(System.currentTimeMillis())));
		
		return getMapping().entityToDto((depositDAO.save(deposit)));
	}

}
