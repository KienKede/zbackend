package com.zitro.zbackend.web.dto.play;

import java.util.Date;

import com.zitro.zbackend.web.dto.game.BasicGameDTO;
import com.zitro.zbackend.web.dto.player.BasicPlayerDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString 
public class PlayDTO extends BasicPlayDTO {
	
	private static final long serialVersionUID = 1L;
	
	private BasicPlayerDTO player;
	
	private BasicGameDTO game;
	
	private float amountWon;

	private Date played;
	
}
