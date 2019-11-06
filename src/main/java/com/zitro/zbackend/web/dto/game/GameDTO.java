package com.zitro.zbackend.web.dto.game;

import com.zitro.zbackend.web.dto.kindofgame.KindOfGameDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString 
public class GameDTO extends BasicGameDTO {

	private static final long serialVersionUID = 1L;
	
	private KindOfGameDTO kindOfGame;

}
