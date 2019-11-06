package com.zitro.zbackend.tools.mapping.domain;

import com.zitro.zbackend.persistence.domain.Game;
import com.zitro.zbackend.web.dto.game.BasicGameDTO;
import com.zitro.zbackend.web.dto.game.CreationGameDTO;
import com.zitro.zbackend.web.dto.game.GameDTO;
import com.zitro.zcommon.tools.mapping.domain.IdAbstractMapping;

public class GameMapping extends IdAbstractMapping<CreationGameDTO, BasicGameDTO, GameDTO, Game> {

	private static GameMapping gameMapping;
	
	@Override
	public Game creationDtoToEntity(CreationGameDTO creationDTO) {
		Game game = basicDtotoToEntity(creationDTO);
		
		return game;
	}

	@Override
	public Game basicDtotoToEntity(BasicGameDTO basicDTO) {
		Game game = new Game();
		
		game.setId(basicDTO.getId());
		game.setName(basicDTO.getName());
		game.setWinProbabilities(basicDTO.getWinProbabilities());
		game.setWinAmount(basicDTO.getWinAmount());
		
		return game;
	}

	@Override
	public Game normalDtoToEntity(GameDTO normalDTO) {
		Game game = basicDtotoToEntity(normalDTO);
		
		game.setKindOfGame(KindOfGameMapping.getMapping().normalDtoToEntity(normalDTO.getKindOfGame()));
		
		return game;
	}

	@Override
	public GameDTO entityToDto(Game entity) {
		GameDTO game = new GameDTO();
		
		game.setId(entity.getId());
		game.setName(entity.getName());
		game.setKindOfGame(KindOfGameMapping.getMapping().entityToDto(entity.getKindOfGame()));
		game.setWinProbabilities(entity.getWinProbabilities());
		game.setWinAmount(entity.getWinAmount());
		
		return game;
	}
	
	public static GameMapping getMapping() {
		if(gameMapping == null) {
			gameMapping = new GameMapping();
		}
		return gameMapping;
	}

}
