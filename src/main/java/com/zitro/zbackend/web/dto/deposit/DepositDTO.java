package com.zitro.zbackend.web.dto.deposit;

import java.util.Date;

import com.zitro.zbackend.web.dto.player.PlayerDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@ToString 
public class DepositDTO extends BasicDepositDTO {

	private static final long serialVersionUID = 1L;
	
	private PlayerDTO player;
	
	private Date deposited;

}
