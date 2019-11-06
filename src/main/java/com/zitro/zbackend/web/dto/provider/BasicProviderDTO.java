package com.zitro.zbackend.web.dto.provider;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zitro.zcommon.web.dto.DtoWithUUIDAndName;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString 
@EqualsAndHashCode
public class BasicProviderDTO implements DtoWithUUIDAndName{

	private static final long serialVersionUID = 1L;
	
	private UUID uuid;
	
	@Size(min=2, max=20, message="{Provider.DTO.validation.name.size}")
	@NotNull(message="{Common.DTO.validation.name.notnull}")
	private String name;

	@Override
	public UUID getUUID() {
		return uuid;
	}

	@Override
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
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
