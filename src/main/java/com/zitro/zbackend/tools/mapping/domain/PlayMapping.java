package com.zitro.zbackend.tools.mapping.domain;

import com.zitro.zbackend.persistence.domain.Play;
import com.zitro.zbackend.web.dto.play.BasicPlayDTO;
import com.zitro.zbackend.web.dto.play.CreationPlayDTO;
import com.zitro.zbackend.web.dto.play.PlayDTO;
import com.zitro.zcommon.tools.mapping.domain.IdAbstractMapping;

public class PlayMapping extends IdAbstractMapping<CreationPlayDTO, BasicPlayDTO, PlayDTO, Play>{
	
	private static PlayMapping playMapping;

	@Override
	public Play creationDtoToEntity(CreationPlayDTO creationDTO) {
		Play play = basicDtotoToEntity(creationDTO);
		
		return play;
	}

	@Override
	public Play basicDtotoToEntity(BasicPlayDTO basicDTO) {
		Play play = new Play();
		
		play.setId(basicDTO.getId());
		play.setAmountPlayed(basicDTO.getAmountPlayed());
		
		return play;
	}

	@Override
	public Play normalDtoToEntity(PlayDTO normalDTO) {
		Play play = basicDtotoToEntity(normalDTO);
		
		play.setPlayer(PlayerMapping.getMapping().basicDtotoToEntity(normalDTO.getPlayer()));
		play.setGame(GameMapping.getMapping().basicDtotoToEntity(normalDTO.getGame()));
		play.setAmountPlayed(normalDTO.getAmountPlayed());
		play.setAmountWon(normalDTO.getAmountWon());
		play.setId(normalDTO.getId());
		play.setPlayed(normalDTO.getPlayed());
		
		return play;
	}

	@Override
	public PlayDTO entityToDto(Play entity) {
		PlayDTO play = new PlayDTO();
		
		play.setPlayer(PlayerMapping.getMapping().entityToDto(entity.getPlayer()));
		play.setGame(GameMapping.getMapping().entityToDto(entity.getGame()));
		play.setAmountPlayed(entity.getAmountPlayed());
		play.setAmountWon(entity.getAmountWon());
		play.setId(entity.getId());
		play.setPlayed(entity.getPlayed());
		
		return play;
	}
	
	public static PlayMapping getMapping() {
		if(playMapping == null) {
			playMapping = new PlayMapping();
		}
		
		return playMapping;
	}

}
