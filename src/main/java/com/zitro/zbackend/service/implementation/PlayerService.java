package com.zitro.zbackend.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.zitro.zbackend.exceptions.DeletedUserException;
import com.zitro.zbackend.persistence.domain.Player;
import com.zitro.zbackend.persistence.domain.Provider;
import com.zitro.zbackend.persistence.repository.jpa.PlayerJpaDao;
import com.zitro.zbackend.service.interfaces.PlayerServiceInterface;
import com.zitro.zbackend.tools.mapping.domain.PlayerMapping;
import com.zitro.zbackend.tools.mapping.domain.ProviderMapping;
import com.zitro.zbackend.web.dto.deposit.DepositDTO;
import com.zitro.zbackend.web.dto.play.PlayDTO;
import com.zitro.zbackend.web.dto.player.BasicPlayerDTO;
import com.zitro.zbackend.web.dto.player.CreationPlayerDTO;
import com.zitro.zbackend.web.dto.player.PlayerDTO;
import com.zitro.zcommon.service.UUIDAbstractService;

@Service
public class PlayerService extends UUIDAbstractService<CreationPlayerDTO, BasicPlayerDTO, PlayerDTO, Player> implements PlayerServiceInterface {

	private PlayerJpaDao playerDAO;
	
	private DepositService depositService;
	private PlayService playService;
	private ProviderService providerService;
	
	public PlayerService(PlayerJpaDao playerDAO, DepositService depositService, PlayService playService, ProviderService providerService) {
		super();
		this.playerDAO = playerDAO;
		this.depositService = depositService;
		this.playService = playService;
		this.providerService = providerService;
	}
	
	@Override
	public PlayerDTO findByName(String name) {
		return getMapping().entityToDto(playerDAO.findByName(name));
	}

	@Override
	protected PlayerJpaDao getDao() {
		return playerDAO;
	}

	@Override
	protected PlayerMapping getMapping() {
		return PlayerMapping.getMapping();
	}
	
	public List<DepositDTO> getAllDepositsByPlayerUUID (UUID uuid) {
		return depositService.getAllDepositsByPlayerUUID(uuid);
	}

	public List<PlayDTO> getAllPlaysByPlayerUUID(UUID uuid) {
		return playService.getAllPlaysByPlayerUUID(uuid);
	}

	public PlayerDTO createPlayer(CreationPlayerDTO playerDTO) {
		Provider provider = ProviderMapping.getMapping().normalDtoToEntity(providerService.findOne(playerDTO.getProviderUUID()));
		
		Player player = new Player();
		
		player.setUUID(UUID.randomUUID());
		player.setName(playerDTO.getName());
		player.setBalance(0f);
		player.setTimeLeft(0);
		player.setCreationDateTime(new Date(System.currentTimeMillis()));
		
		player.setProvider(provider);
		
		return PlayerMapping.getMapping().entityToDto(getDao().save(player));		
	}

	public void update(Player player) {
		getDao().save(player);
	}

	public void logicalDelete(UUID uuid) throws DeletedUserException {
		Player player = getMapping().normalDtoToEntity(findOne(uuid));
		
		Preconditions.checkNotNull(player);
		
		if(player.isDeleted()) {
			throw new DeletedUserException("The user " + player.getUUID() + " is already deleted!");
		}
		
		player.setDeleted(true);
		
		playerDAO.save(player);
	}
	
}
