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

import com.zitro.zbackend.exceptions.DeletedUserException;
import com.zitro.zbackend.service.implementation.DepositService;
import com.zitro.zbackend.tools.mapping.properties.Query;
import com.zitro.zbackend.tools.mapping.properties.Request;
import com.zitro.zbackend.web.dto.deposit.BasicDepositDTO;
import com.zitro.zbackend.web.dto.deposit.CreationDepositDTO;
import com.zitro.zbackend.web.dto.deposit.DepositDTO;
import com.zitro.zcommon.web.controller.IdAbstractController;
import com.zitro.zcommon.web.controller.IdSortingControllerInterface;

@RestController
@RequestMapping(Request.DEPOSIT)
public class DepositController extends IdAbstractController<CreationDepositDTO, BasicDepositDTO, DepositDTO> implements IdSortingControllerInterface<DepositDTO>{

	private DepositService depositService;
	
	public DepositController (DepositService depositService) {
		super();
		this.depositService = depositService;
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE, Query.SORT_BY })
	public List<DepositDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
		return this.findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE })
	public List<DepositDTO> findAllPaginated(int page, int size) {
		return this.findPaginatedInternal(page, size);
	}
	
	@Override
	@GetMapping(params = { Query.SORT_BY })
	public List<DepositDTO> findAllSorted(String sortBy, String sortOrder) {
		return this.findAllSortedInternal(sortBy, sortOrder);
	}
	
	@Override
	@GetMapping
	public List<DepositDTO> findAll(HttpServletRequest request) {
		return findAllInternal(request);
	}
	
	@GetMapping("/{id}")
	public DepositDTO findOne(@PathVariable Long id) {
		return this.findOneInternal(id);
	}
	
//	@DeleteMapping("/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteById(@PathVariable Long id) {
//		this.deleteByIdInternal(id);
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DepositDTO create(@Valid @RequestBody CreationDepositDTO deposit) throws DeletedUserException {
		return getService().createDeposit(deposit);
	}
	
//	@PutMapping("/{id}")
//  @ResponseStatus(HttpStatus.OK)
//  public void update(@PathVariable Long id, @Valid @RequestBody BasicPlayDTO player) {
//      updateInternal(id, player);
//  }

	@Override
	protected DepositService getService() {
		return depositService;
	}

}
