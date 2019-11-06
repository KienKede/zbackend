package com.zitro.zbackend.web.dto.play;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.zitro.zcommon.web.dto.DtoWithId;

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
public class BasicPlayDTO implements DtoWithId {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Min(value = 1, message = "{Play.DTO.validation.amountPlayed.min}")
	@NotNull(message = "Play.DTO.validation.amountPlayed.notnull")
	private float amountPlayed;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
