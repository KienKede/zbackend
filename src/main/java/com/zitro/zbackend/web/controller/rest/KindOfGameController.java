package com.zitro.zbackend.web.controller.rest;

import java.util.List;

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

import com.zitro.zbackend.service.implementation.KindOfGameService;
import com.zitro.zbackend.tools.mapping.properties.Query;
import com.zitro.zbackend.tools.mapping.properties.Request;
import com.zitro.zbackend.web.dto.kindofgame.BasicKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.CreationKindOfGameDTO;
import com.zitro.zbackend.web.dto.kindofgame.KindOfGameDTO;
import com.zitro.zcommon.web.controller.IdAbstractController;
import com.zitro.zcommon.web.controller.IdSortingControllerInterface;

@RestController
@RequestMapping(Request.KIND_OF_GAMES)
public class KindOfGameController extends IdAbstractController<CreationKindOfGameDTO, BasicKindOfGameDTO, KindOfGameDTO> implements IdSortingControllerInterface<KindOfGameDTO>{

	KindOfGameService kindOfGameService;
	
	public KindOfGameController(KindOfGameService kindOfGameService) {
		super();
		this.kindOfGameService = kindOfGameService;
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE, Query.SORT_BY })
	public List<KindOfGameDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
		return this.findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE })
	public List<KindOfGameDTO> findAllPaginated(int page, int size) {
		return this.findPaginatedInternal(page, size);
	}
	
	@Override
	@GetMapping(params = { Query.SORT_BY })
	public List<KindOfGameDTO> findAllSorted(String sortBy, String sortOrder) {
		return this.findAllSortedInternal(sortBy, sortOrder);
	}
	
	@Override
	@GetMapping
	public List<KindOfGameDTO> findAll(HttpServletRequest request) {
		return findAllInternal(request);
	}
	
	@GetMapping("/{id}")
	public KindOfGameDTO findOne(@PathVariable Long id) {
		return this.findOneInternal(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		this.deleteByIdInternal(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public KindOfGameDTO create(@Valid @RequestBody CreationKindOfGameDTO kindOfGame) {
		return this.createInternal(kindOfGame);
	}
	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @Valid @RequestBody BasicKindOfGameDTO kindOfGame) {
        updateInternal(id, kindOfGame);
    }

	@Override
	protected KindOfGameService getService() {
		return kindOfGameService;
	}

}
