package com.zitro.zbackend.web.dto.player;

import java.util.Date;

import com.zitro.zbackend.web.dto.provider.ProviderDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString 
public class PlayerDTO extends BasicPlayerDTO {
	
	private static final long serialVersionUID = 1L;
	
	private float balance;
	
	private float timeLeft;
	
	private boolean deleted;
	
	private Date creationDateTime;
	
	private ProviderDTO provider;
}
