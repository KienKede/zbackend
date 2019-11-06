package com.zitro.zbackend.tools.mapping.domain;

import java.util.Date;

import com.zitro.zbackend.persistence.domain.Provider;
import com.zitro.zbackend.web.dto.provider.BasicProviderDTO;
import com.zitro.zbackend.web.dto.provider.CreationProviderDTO;
import com.zitro.zbackend.web.dto.provider.ProviderDTO;
import com.zitro.zcommon.tools.mapping.domain.UUIDAbstractMapping;

public class ProviderMapping extends UUIDAbstractMapping<CreationProviderDTO, BasicProviderDTO, ProviderDTO, Provider> {

	private static ProviderMapping providerMapping;
	
	@Override
	public Provider creationDtoToEntity(CreationProviderDTO creationDTO) {
		Provider provider = basicDtotoToEntity(creationDTO);
		
		provider.setCreationDateTime(new Date(System.currentTimeMillis()));
		
		return provider;
	}

	@Override
	public Provider basicDtotoToEntity(BasicProviderDTO basicDTO) {
		Provider provider = new Provider();
		
		provider.setName(basicDTO.getName());
		provider.setUUID(basicDTO.getUUID());
		
		return provider;
	}

	@Override
	public Provider normalDtoToEntity(ProviderDTO normalDTO) {
		Provider provider = basicDtotoToEntity(normalDTO);
		
		provider.setCreationDateTime(normalDTO.getCreationDateTime());
		
		return provider;
	}

	@Override
	public ProviderDTO entityToDto(Provider entity) {
		ProviderDTO provider = new ProviderDTO();
		
		provider.setUUID(entity.getUUID());
		provider.setName(entity.getName());
		provider.setCreationDateTime(entity.getCreationDateTime());
		
		return provider;
	}
	
	public static ProviderMapping getMapping() {
		if(providerMapping == null) {
			providerMapping = new ProviderMapping();
		}
		
		return providerMapping;
	}

}
