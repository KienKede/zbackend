package com.zitro.zbackend.web.dto.kindofgame;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString 
@JsonIgnoreProperties("id")
public class CreationKindOfGameDTO extends BasicKindOfGameDTO {

	private static final long serialVersionUID = 1L;

}
