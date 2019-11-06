package com.zitro.zbackend.web.dto.player;

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
@JsonIgnoreProperties("uuid")
public class CreationPlayerDTO extends BasicPlayerDTO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message="{Player.DTO.validation.providerUUID.notnull}")
	private UUID providerUUID;

}
