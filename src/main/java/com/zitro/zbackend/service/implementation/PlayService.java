package com.zitro.zbackend.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;
import com.zitro.zbackend.exceptions.DeletedUserException;
import com.zitro.zbackend.exceptions.NoFundsException;
import com.zitro.zbackend.persistence.domain.Game;
import com.zitro.zbackend.persistence.domain.Play;
import com.zitro.zbackend.persistence.domain.Player;
import com.zitro.zbackend.persistence.repository.jpa.PlayJpaDao;
import com.zitro.zbackend.service.interfaces.PlayServiceInterface;
import com.zitro.zbackend.tools.mapping.domain.GameMapping;
import com.zitro.zbackend.tools.mapping.domain.PlayMapping;
import com.zitro.zbackend.tools.mapping.domain.PlayerMapping;
import com.zitro.zbackend.web.dto.play.BasicPlayDTO;
import com.zitro.zbackend.web.dto.play.CreationPlayDTO;
import com.zitro.zbackend.web.dto.play.PlayDTO;
import com.zitro.zcommon.service.IdAbstractService;

@Service
public class PlayService extends IdAbstractService<CreationPlayDTO, BasicPlayDTO, PlayDTO, Play> implements PlayServiceInterface {

	private static Logger logger = LogManager.getLogger("com.zitro");
	
	private PlayJpaDao playDAO;
	
	private PlayerService playerService;
	private GameService gameService;
	
	public PlayService(PlayJpaDao playDAO, @Lazy PlayerService playerService, GameService gameService) {
		super();
		this.playDAO = playDAO;
		this.playerService = playerService;
		this.gameService = gameService;
	}
	
	@Override
	protected PlayJpaDao getDao() {
		return playDAO;
	}

	@Override
	protected PlayMapping getMapping() {
		return PlayMapping.getMapping();
	}

	public List<PlayDTO> getAllPlaysByPlayerUUID(UUID uuid) {
		return getMapping().entityToDtoList(playDAO.findAllByPlayerUUID(uuid));
	}

	@Transactional
	public PlayDTO createPlay(CreationPlayDTO playDTO) throws NoFundsException, DeletedUserException {
		Preconditions.checkNotNull(playDTO);
		
		Player player = PlayerMapping.getMapping().normalDtoToEntity(playerService.findOne(playDTO.getPlayer()));
		
		Preconditions.checkNotNull(player);
		
		if(player.isDeleted()) {
			throw new DeletedUserException("The user " + player.getUUID() + " is deleted!");
		}		

		if(player.getBalance()<playDTO.getAmountPlayed()) {
			String message = "Not enough funds for player: " + player.getUUID() + " - Funds: " + player.getBalance() + " < Amount Played: " + playDTO.getAmountPlayed();
			throw new NoFundsException(message);
		}
		
		Game game = GameMapping.getMapping().normalDtoToEntity(gameService.findOne(playDTO.getGame()));
		
		Preconditions.checkNotNull(game);
		
		Play play = new Play();
		
		play.setAmountPlayed(playDTO.getAmountPlayed());
		play.setPlayed(new Date(System.currentTimeMillis()));
		
		int probabilities = game.getWinProbabilities();
		
		Random r = new Random();
		int low = 0;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		
		//Win or lose
		if(result<probabilities) {
			play.setAmountWon(game.getWinAmount()*play.getAmountPlayed());
		} else {
			play.setAmountWon(0f);
		}
		
		float balance = play.getAmountWon() - play.getAmountPlayed();
		
		//Update player balance
		player.setBalance(player.getBalance()-play.getAmountPlayed()+play.getAmountWon());
		
		playerService.update(player);
		
		play.setPlayer(player);
		play.setGame(game);
		
		play = playDAO.save(play);
		
		logger.info("Transaction "+play.getId()+" - Player: "+player.getUUID()+" Increment: "+balance+" Game: "+game.getName());
		
		return getMapping().entityToDto(play);
	}

}
