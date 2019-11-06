package com.zitro.zbackend.tools.mapping.domain;

import com.zitro.zbackend.persistence.domain.Deposit;
import com.zitro.zbackend.web.dto.deposit.BasicDepositDTO;
import com.zitro.zbackend.web.dto.deposit.CreationDepositDTO;
import com.zitro.zbackend.web.dto.deposit.DepositDTO;
import com.zitro.zcommon.tools.mapping.domain.IdAbstractMapping;

public class DepositMapping extends IdAbstractMapping<CreationDepositDTO, BasicDepositDTO, DepositDTO, Deposit> {

	private static DepositMapping depositMapping;
	
	@Override
	public Deposit creationDtoToEntity(CreationDepositDTO creationDTO) {
		Deposit deposit = basicDtotoToEntity(creationDTO);
		
		return deposit;
	}

	@Override
	public Deposit basicDtotoToEntity(BasicDepositDTO basicDTO) {
		Deposit deposit = new Deposit();
		
		deposit.setId(basicDTO.getId());
		deposit.setAmount(basicDTO.getAmount());
		
		return deposit;
	}

	@Override
	public Deposit normalDtoToEntity(DepositDTO normalDTO) {
		Deposit deposit = basicDtotoToEntity(normalDTO);
		
		deposit.setDeposited(normalDTO.getDeposited());
		deposit.setPlayer(PlayerMapping.getMapping().normalDtoToEntity(normalDTO.getPlayer()));
		
		return deposit;
	}

	@Override
	public DepositDTO entityToDto(Deposit entity) {
		DepositDTO deposit = new DepositDTO();
		
		deposit.setId(entity.getId());
		deposit.setAmount(entity.getAmount());
		deposit.setDeposited(entity.getDeposited());
		deposit.setPlayer(PlayerMapping.getMapping().entityToDto(entity.getPlayer()));
		
		return deposit;
	}
	
	public static DepositMapping getMapping() {
		if(depositMapping == null) {
			depositMapping = new DepositMapping();
		}
		
		return depositMapping;
	}

}
