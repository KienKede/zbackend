package com.zitro.zbackend.web.dto.play;

import java.util.UUID;

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
public class CreationPlayDTO extends BasicPlayDTO {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Common.DTO.validation.playerUUID.notNull")
	private UUID player;
 
	@NotNull(message = "Common.DTO.validation.gameId.notNull")
    private Long game;
	
}
