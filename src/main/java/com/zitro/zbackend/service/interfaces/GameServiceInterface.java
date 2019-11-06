package com.zitro.zbackend.service.interfaces;

import com.zitro.zbackend.web.dto.game.BasicGameDTO;
import com.zitro.zbackend.web.dto.game.CreationGameDTO;
import com.zitro.zbackend.web.dto.game.GameDTO;
import com.zitro.zcommon.common.FindByNameInterface;
import com.zitro.zcommon.service.IdServiceInterface;

public interface GameServiceInterface extends IdServiceInterface<CreationGameDTO, BasicGameDTO, GameDTO>, FindByNameInterface<BasicGameDTO>{

}
