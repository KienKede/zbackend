package com.zitro.zbackend.tools.mapping.domain;

import com.zitro.zbackend.persistence.domain.Player;
import com.zitro.zbackend.web.dto.player.BasicPlayerDTO;
import com.zitro.zbackend.web.dto.player.CreationPlayerDTO;
import com.zitro.zbackend.web.dto.player.PlayerDTO;
import com.zitro.zcommon.tools.mapping.domain.UUIDAbstractMapping;

public class PlayerMapping extends UUIDAbstractMapping<CreationPlayerDTO, BasicPlayerDTO, PlayerDTO, Player>{

	private static PlayerMapping playerMapping;
	
	@Override
	public Player creationDtoToEntity(CreationPlayerDTO creationDTO) {
		Player player = basicDtotoToEntity(creationDTO);
				
		return player;
	}

	@Override
	public Player basicDtotoToEntity(BasicPlayerDTO basicDTO) {
		Player player = new Player();
		
		player.setUUID(basicDTO.getUUID());
		player.setName(basicDTO.getName());
		
		return player;
	}

	@Override
	public Player normalDtoToEntity(PlayerDTO normalDTO) {
		Player player = basicDtotoToEntity(normalDTO);
		
		player.setBalance(normalDTO.getBalance());
		player.setTimeLeft(normalDTO.getTimeLeft());
		player.setCreationDateTime(normalDTO.getCreationDateTime());
		player.setProvider(ProviderMapping.getMapping().normalDtoToEntity(normalDTO.getProvider()));
		player.setDeleted(normalDTO.isDeleted());
		
		return player;
	}

	@Override
	public PlayerDTO entityToDto(Player entity) {
		PlayerDTO player = new PlayerDTO();
		
		player.setUUID(entity.getUUID());
		player.setName(entity.getName());
		player.setBalance(entity.getBalance());
		player.setTimeLeft(entity.getTimeLeft());
		player.setCreationDateTime(entity.getCreationDateTime());
		player.setProvider(ProviderMapping.getMapping().entityToDto(entity.getProvider()));
		player.setDeleted(entity.isDeleted());
		
		return player;
	}
	
	public PlayerDTO entityToBasicDto(Player entity) {
		PlayerDTO player = new PlayerDTO();
		
		player.setUUID(entity.getUUID());
		player.setName(entity.getName());
		
		return player;
	}
	
	public static PlayerMapping getMapping() {
		if(playerMapping == null) {
			playerMapping = new PlayerMapping();
		}
		
		return playerMapping;
	}

}
