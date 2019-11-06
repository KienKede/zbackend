package com.zitro.zbackend.tools.mapping.domain;

import com.zitro.zbackend.persistence.domain.KindOfGame;
import com.zitro.zbackend.web.dto.kindofgame.BasicKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.CreationKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.KindOfGameDTO;
import com.zitro.zcommon.tools.mapping.domain.IdAbstractMapping;

public class KindOfGameMapping extends IdAbstractMapping<CreationKindOfGameDTO, BasicKindOfGameDTO, KindOfGameDTO, KindOfGame> {

	private static KindOfGameMapping kindOfGameMapping;
	
	@Override
	public KindOfGame creationDtoToEntity(CreationKindOfGameDTO creationDTO) {
		KindOfGame kindOfGame = basicDtotoToEntity(creationDTO);
		
		return kindOfGame;
	}

	@Override
	public KindOfGame basicDtotoToEntity(BasicKindOfGameDTO basicDTO) {
		KindOfGame kindOfGame = new KindOfGame();
		
		kindOfGame.setId(basicDTO.getId());
		kindOfGame.setName(basicDTO.getName());
		
		return kindOfGame;
	}

	@Override
	public KindOfGame normalDtoToEntity(KindOfGameDTO normalDTO) {
		KindOfGame kindOfGame = basicDtotoToEntity(normalDTO);
		
		return kindOfGame;
	}

	@Override
	public KindOfGameDTO entityToDto(KindOfGame entity) {
		KindOfGameDTO kindOfGame = new KindOfGameDTO();
		
		kindOfGame.setId(entity.getId());
		kindOfGame.setName(entity.getName());
		
		return kindOfGame;
	}
	
	public static KindOfGameMapping getMapping() {
		if(kindOfGameMapping == null) {
			kindOfGameMapping = new KindOfGameMapping();
		}
		return kindOfGameMapping;
	}

}
