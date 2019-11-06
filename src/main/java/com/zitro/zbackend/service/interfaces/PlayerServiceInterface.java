package com.zitro.zbackend.service.interfaces;

import com.zitro.zbackend.web.dto.player.BasicPlayerDTO;
import com.zitro.zbackend.web.dto.player.CreationPlayerDTO;
import com.zitro.zbackend.web.dto.player.PlayerDTO;
import com.zitro.zcommon.common.FindByNameInterface;
import com.zitro.zcommon.service.UUIDServiceInterface;

public interface PlayerServiceInterface extends UUIDServiceInterface<CreationPlayerDTO, BasicPlayerDTO, PlayerDTO>, FindByNameInterface<PlayerDTO>{

}
