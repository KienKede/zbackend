package com.zitro.zbackend.web.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zitro.zbackend.service.implementation.GameService;
import com.zitro.zbackend.tools.mapping.properties.Query;
import com.zitro.zbackend.tools.mapping.properties.Request;
import com.zitro.zbackend.web.dto.game.BasicGameDTO;
import com.zitro.zbackend.web.dto.game.CreationGameDTO;
import com.zitro.zbackend.web.dto.game.GameDTO;
import com.zitro.zcommon.web.controller.IdAbstractController;
import com.zitro.zcommon.web.controller.IdSortingControllerInterface;

@RestController
@RequestMapping(Request.GAMES)
public class GameController extends IdAbstractController<CreationGameDTO, BasicGameDTO, GameDTO> implements IdSortingControllerInterface<GameDTO>{

	GameService gameService;
	
	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE, Query.SORT_BY })
	public List<GameDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
		return this.findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE })
	public List<GameDTO> findAllPaginated(int page, int size) {
		return this.findPaginatedInternal(page, size);
	}
	
	@Override
	@GetMapping(params = { Query.SORT_BY })
	public List<GameDTO> findAllSorted(String sortBy, String sortOrder) {
		return this.findAllSortedInternal(sortBy, sortOrder);
	}
	
	@Override
	@GetMapping
	public List<GameDTO> findAll(HttpServletRequest request) {
		return findAllInternal(request);
	}
	
	@GetMapping("/{id}")
	public GameDTO findOne(@PathVariable Long id) {
		return this.findOneInternal(id);
	}
	
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteById(@PathVariable Long id) {
//		this.deleteByIdInternal(id);
//	}
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public GameDTO create(@Valid @RequestBody CreationGameDTO game) {
//		return this.createInternal(game);
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GameDTO create(@Valid @RequestBody CreationGameDTO game) {
		return getService().createGame(game);
	}
	
//	@PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@PathVariable Long id, @Valid @RequestBody BasicGameDTO game) {
//        updateInternal(id, game);
//    }

	@Override
	protected GameService getService() {
		return gameService;
	}

}
