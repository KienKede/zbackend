package com.zitro.zbackend.web.controller.rest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zitro.zbackend.exceptions.DeletedUserException;
import com.zitro.zbackend.service.implementation.PlayerService;
import com.zitro.zbackend.tools.mapping.properties.Query;
import com.zitro.zbackend.tools.mapping.properties.Request;
import com.zitro.zbackend.web.dto.deposit.DepositDTO;
import com.zitro.zbackend.web.dto.play.PlayDTO;
import com.zitro.zbackend.web.dto.player.BasicPlayerDTO;
import com.zitro.zbackend.web.dto.player.CreationPlayerDTO;
import com.zitro.zbackend.web.dto.player.PlayerDTO;
import com.zitro.zcommon.web.controller.UUIDAbstractController;
import com.zitro.zcommon.web.controller.UUIDSortingControllerInterface;

@RestController
@RequestMapping(Request.PLAYERS)
public class PlayerController extends UUIDAbstractController<CreationPlayerDTO, BasicPlayerDTO, PlayerDTO> implements UUIDSortingControllerInterface<PlayerDTO>{ 

	PlayerService playerService;
	
	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE, Query.SORT_BY })
	public List<PlayerDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
		return this.findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE })
	public List<PlayerDTO> findAllPaginated(int page, int size) {
		return this.findPaginatedInternal(page, size);
	}
	
	@Override
	@GetMapping(params = { Query.SORT_BY })
	public List<PlayerDTO> findAllSorted(String sortBy, String sortOrder) {
		return this.findAllSortedInternal(sortBy, sortOrder);
	}
	
	@Override
	@GetMapping
	public List<PlayerDTO> findAll(HttpServletRequest request) {
		return findAllInternal(request);
	}
	
	@GetMapping("/{uuid}")
	public PlayerDTO findOne(@PathVariable UUID uuid) {
		return this.findOneInternal(uuid);
	}
	
	@GetMapping("/{uuid}/deposits")
	public List<DepositDTO> findAllDepositsByPlayer(@PathVariable UUID uuid) {
		return getService().getAllDepositsByPlayerUUID(uuid);
	}
	
	@GetMapping("/{uuid}/plays")
	public List<PlayDTO> findAllPlaysByPlayer(@PathVariable UUID uuid) {
		return getService().getAllPlaysByPlayerUUID(uuid);
	}
	
	@DeleteMapping("/{uuid}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable UUID uuid) throws DeletedUserException {
		getService().logicalDelete(uuid);
	}
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public PlayerDTO create(@Valid @RequestBody CreationPlayerDTO player) {
//		return this.createInternal(player);
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerDTO create(@Valid @RequestBody CreationPlayerDTO player) {
		return getService().createPlayer(player);
	}
	
	@PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable UUID uuid, @Valid @RequestBody BasicPlayerDTO player) {
        updateInternal(uuid, player);
    }
	
	@Override
	protected PlayerService getService() {
		return playerService;
	}
}
