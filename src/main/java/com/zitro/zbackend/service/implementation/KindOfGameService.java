package com.zitro.zbackend.service.implementation;

import org.springframework.stereotype.Service;

import com.zitro.zbackend.persistence.domain.KindOfGame;
import com.zitro.zbackend.persistence.repository.jpa.KindOfGameJpaDao;
import com.zitro.zbackend.service.interfaces.KindOfGameServiceInterface;
import com.zitro.zbackend.tools.mapping.domain.KindOfGameMapping;
import com.zitro.zbackend.web.dto.kindofgame.BasicKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.CreationKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.KindOfGameDTO;
import com.zitro.zcommon.service.IdAbstractService;

@Service
public class KindOfGameService extends IdAbstractService<CreationKindOfGameDTO, BasicKindOfGameDTO, KindOfGameDTO, KindOfGame> implements KindOfGameServiceInterface {

	private KindOfGameJpaDao kindOfGameDAO;
	
	public KindOfGameService(KindOfGameJpaDao kindOfGameDAO) {
		super();
		this.kindOfGameDAO = kindOfGameDAO;
	}
	
	@Override
	public KindOfGameDTO findByName(String name) {
		return getMapping().entityToDto(kindOfGameDAO.findByName(name));
	}

	@Override
	protected KindOfGameJpaDao getDao() {
		return kindOfGameDAO;
	}

	@Override
	protected KindOfGameMapping getMapping() {
		return KindOfGameMapping.getMapping();
	}

}
