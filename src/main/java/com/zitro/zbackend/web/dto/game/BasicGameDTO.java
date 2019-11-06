package com.zitro.zbackend.web.dto.game;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zitro.zcommon.web.dto.DtoWithIdAndName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString 
@EqualsAndHashCode
public class BasicGameDTO implements DtoWithIdAndName {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min=2, max=20, message="{Game.DTO.validation.name.size}")
	@NotNull(message="{Common.DTO.validation.name.notnull}")
	private String name;
	
	@Min(value = 1, message = "{Game.DTO.validation.winProbabilities.min}")
	@Max(value = 99, message = "{Game.DTO.validation.winProbabilities.max}")
	@NotNull(message="{Game.DTO.validation.winProbabilities.notnull}")
	private int winProbabilities;
	
	@Min(value = 1, message = "{Game.DTO.validation.winAmount.min}")
	@NotNull(message="{Game.DTO.validation.winAmount.notnull}")
	private float winAmount;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
