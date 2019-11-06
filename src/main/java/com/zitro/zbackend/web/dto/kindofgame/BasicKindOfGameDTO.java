package com.zitro.zbackend.web.dto.kindofgame;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zitro.zcommon.web.dto.DtoWithIdAndName;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString 
@EqualsAndHashCode
public class BasicKindOfGameDTO implements DtoWithIdAndName {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min=2, max=20, message="{KindOfGame.DTO.validation.name.size}")
	@NotNull(message="{Common.DTO.validation.name.notnull}")
	private String name;

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
