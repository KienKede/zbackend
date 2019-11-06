package com.zitro.zbackend.web.dto.provider;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString 
public class ProviderDTO extends BasicProviderDTO {

	private static final long serialVersionUID = 1L;
	
	private Date creationDateTime;
	
}
