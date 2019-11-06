package com.zitro.zbackend.web.dto.deposit;

import javax.validation.constraints.Max;
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
public class BasicDepositDTO implements DtoWithId {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Min(value = (long) 0.1, message = "{Deposit.DTO.validation.amount.min}")
	@Max(value = 150, message = "{Deposit.DTO.validation.amount.max}")
	@NotNull(message = "{Deposit.DTO.validation.amount.notnull}")
	private float amount;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
