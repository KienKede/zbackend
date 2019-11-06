package com.zitro.zbackend.web.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.zitro.zbackend.exceptions.DeletedUserException;
import com.zitro.zbackend.exceptions.NoFundsException;
import com.zitro.zbackend.service.implementation.PlayService;
import com.zitro.zbackend.tools.mapping.properties.Query;
import com.zitro.zbackend.tools.mapping.properties.Request;
import com.zitro.zbackend.web.dto.play.BasicPlayDTO;
import com.zitro.zbackend.web.dto.play.CreationPlayDTO;
import com.zitro.zbackend.web.dto.play.PlayDTO;
import com.zitro.zcommon.web.controller.IdAbstractController;
import com.zitro.zcommon.web.controller.IdSortingControllerInterface;

@RestController
@RequestMapping(Request.PLAY)
public class PlayController extends IdAbstractController<CreationPlayDTO, BasicPlayDTO, PlayDTO> implements IdSortingControllerInterface<PlayDTO>{

	private static Logger logger = LogManager.getLogger("com.zitro");
	
	private PlayService playService;
	
	public PlayController(PlayService playService) {
		super();
		this.playService = playService;
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE, Query.SORT_BY })
	public List<PlayDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
		return this.findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE })
	public List<PlayDTO> findAllPaginated(int page, int size) {
		return this.findPaginatedInternal(page, size);
	}
	
	@Override
	@GetMapping(params = { Query.SORT_BY })
	public List<PlayDTO> findAllSorted(String sortBy, String sortOrder) {
		return this.findAllSortedInternal(sortBy, sortOrder);
	}
	
	@Override
	@GetMapping
	public List<PlayDTO> findAll(HttpServletRequest request) {
		return findAllInternal(request);
	}
	
	@GetMapping("/{id}")
	public PlayDTO findOne(@PathVariable Long id) {
		return this.findOneInternal(id);
	}
	
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteById(@PathVariable Long id) {
//		this.deleteByIdInternal(id);
//	}
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public PlayDTO create(@Valid @RequestBody CreationPlayDTO play) {
//		return this.createInternal(play);
//	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public PlayDTO create(@Valid @RequestBody CreationPlayDTO play) throws NoFundsException, DeletedUserException {
		try {
			return getService().createPlay(play);
		} catch (NoFundsException noFundsException) {
			logger.error(noFundsException.getMessage(), noFundsException);
			throw noFundsException;
		}
	}
	
//	@PutMapping("/{id}")
//  @ResponseStatus(HttpStatus.OK)
//  public void update(@PathVariable Long id, @Valid @RequestBody BasicPlayDTO player) {
//      updateInternal(id, player);
//  }

	@Override
	protected PlayService getService() {
		return playService;
	}

}
