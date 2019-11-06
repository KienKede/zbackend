package com.zitro.zbackend.web.dto.provider;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString 
@JsonIgnoreProperties("uuid")
public class CreationProviderDTO extends BasicProviderDTO {

	private static final long serialVersionUID = 1L;

}
