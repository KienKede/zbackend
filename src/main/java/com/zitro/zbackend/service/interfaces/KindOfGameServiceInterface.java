package com.zitro.zbackend.service.interfaces;

import com.zitro.zbackend.web.dto.kindofgame.BasicKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.CreationKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.KindOfGameDTO;
import com.zitro.zcommon.common.FindByNameInterface;
import com.zitro.zcommon.service.IdServiceInterface;

public interface KindOfGameServiceInterface extends IdServiceInterface<CreationKindOfGameDTO, BasicKindOfGameDTO, KindOfGameDTO>, FindByNameInterface<BasicKindOfGameDTO>{

}
