package com.zitro.zbackend.web.dto.game;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString 
@JsonIgnoreProperties("id")
public class CreationGameDTO extends BasicGameDTO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Game.DTO.validation.kindOfGameId.notNull")
	private Long kindOfGameId;

}
