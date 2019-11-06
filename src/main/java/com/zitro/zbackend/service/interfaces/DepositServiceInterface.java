package com.zitro.zbackend.service.interfaces;

import com.zitro.zbackend.web.dto.deposit.BasicDepositDTO;
import com.zitro.zbackend.web.dto.deposit.CreationDepositDTO;
import com.zitro.zbackend.web.dto.deposit.DepositDTO;
import com.zitro.zcommon.service.IdServiceInterface;

public interface DepositServiceInterface extends IdServiceInterface<CreationDepositDTO, BasicDepositDTO, DepositDTO>{

}
