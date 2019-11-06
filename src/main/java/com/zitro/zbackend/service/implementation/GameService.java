package com.zitro.zbackend.service.implementation;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.zitro.zbackend.persistence.domain.Game;
import com.zitro.zbackend.persistence.domain.KindOfGame;
import com.zitro.zbackend.persistence.repository.jpa.GameJpaDao;
import com.zitro.zbackend.service.interfaces.GameServiceInterface;
import com.zitro.zbackend.tools.mapping.domain.GameMapping;
import com.zitro.zbackend.tools.mapping.domain.KindOfGameMapping;
import com.zitro.zbackend.web.dto.game.BasicGameDTO;
import com.zitro.zbackend.web.dto.game.CreationGameDTO;
import com.zitro.zbackend.web.dto.game.GameDTO;
import com.zitro.zcommon.service.IdAbstractService;

@Service
public class GameService extends IdAbstractService<CreationGameDTO, BasicGameDTO, GameDTO, Game> implements GameServiceInterface {

	private GameJpaDao gameDAO;
	
	private KindOfGameService kindOfGameService;
	
	public GameService(GameJpaDao gameDAO, KindOfGameService kindOfGameService) {
		super();
		this.gameDAO = gameDAO;
		this.kindOfGameService = kindOfGameService;
	}
	
	@Override
	public GameDTO findByName(String name) {
		return getMapping().entityToDto(gameDAO.findByName(name));
	}

	@Override
	protected GameJpaDao getDao() {
		return gameDAO;
	}

	@Override
	protected GameMapping getMapping() {
		return GameMapping.getMapping();
	}

	public GameDTO createGame(CreationGameDTO gameDTO) {
		Preconditions.checkNotNull(gameDTO);
		
		KindOfGame kindOfGame = KindOfGameMapping.getMapping().normalDtoToEntity(kindOfGameService.findOne(gameDTO.getKindOfGameId()));
	
		Preconditions.checkNotNull(kindOfGame);
		
		Game game = new Game();
		
		game.setKindOfGame(kindOfGame);
		game.setName(gameDTO.getName());
		game.setWinAmount(gameDTO.getWinAmount());
		game.setWinProbabilities(gameDTO.getWinProbabilities());
		
		return getMapping().entityToDto(getDao().save(game));
	}
}
