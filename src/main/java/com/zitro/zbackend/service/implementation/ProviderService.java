package com.zitro.zbackend.service.implementation;

import org.springframework.stereotype.Service;

import com.zitro.zbackend.persistence.domain.Provider;
import com.zitro.zbackend.persistence.repository.jpa.ProviderJpaDao;
import com.zitro.zbackend.service.interfaces.ProviderServiceInterface;
import com.zitro.zbackend.tools.mapping.domain.ProviderMapping;
import com.zitro.zbackend.web.dto.provider.BasicProviderDTO;
import com.zitro.zbackend.web.dto.provider.CreationProviderDTO;
import com.zitro.zbackend.web.dto.provider.ProviderDTO;
import com.zitro.zcommon.service.UUIDAbstractService;

@Service
public class ProviderService extends UUIDAbstractService<CreationProviderDTO, BasicProviderDTO, ProviderDTO, Provider> implements ProviderServiceInterface {

	private ProviderJpaDao providerDAO;
	
	public ProviderService(ProviderJpaDao providerDAO) {
		super();
		this.providerDAO = providerDAO;
	}
	
	@Override
	public ProviderDTO findByName(String name) {
		return getMapping().entityToDto(providerDAO.findByName(name));
	}

	@Override
	protected ProviderJpaDao getDao() {
		return providerDAO;
	}

	@Override
	protected ProviderMapping getMapping() {
		return ProviderMapping.getMapping();
	}
	
}
