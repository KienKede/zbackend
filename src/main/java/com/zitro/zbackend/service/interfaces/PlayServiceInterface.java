package com.zitro.zbackend.service.interfaces;

import com.zitro.zbackend.web.dto.play.BasicPlayDTO;
import com.zitro.zbackend.web.dto.play.CreationPlayDTO;
import com.zitro.zbackend.web.dto.play.PlayDTO;
import com.zitro.zcommon.service.IdServiceInterface;

public interface PlayServiceInterface extends IdServiceInterface<CreationPlayDTO, BasicPlayDTO, PlayDTO>{

}
