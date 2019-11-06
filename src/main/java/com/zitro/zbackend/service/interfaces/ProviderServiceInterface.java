package com.zitro.zbackend.service.interfaces;

import com.zitro.zbackend.web.dto.provider.BasicProviderDTO;
import com.zitro.zbackend.web.dto.provider.CreationProviderDTO;
import com.zitro.zbackend.web.dto.provider.ProviderDTO;
import com.zitro.zcommon.common.FindByNameInterface;
import com.zitro.zcommon.service.UUIDServiceInterface;

public interface ProviderServiceInterface extends UUIDServiceInterface<CreationProviderDTO, BasicProviderDTO, ProviderDTO>, FindByNameInterface<BasicProviderDTO> {

}
