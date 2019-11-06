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

import com.zitro.zbackend.service.implementation.ProviderService;
import com.zitro.zbackend.tools.mapping.properties.Query;
import com.zitro.zbackend.tools.mapping.properties.Request;
import com.zitro.zbackend.web.dto.provider.BasicProviderDTO;
import com.zitro.zbackend.web.dto.provider.CreationProviderDTO;
import com.zitro.zbackend.web.dto.provider.ProviderDTO;
import com.zitro.zcommon.web.controller.UUIDAbstractController;
import com.zitro.zcommon.web.controller.UUIDSortingControllerInterface;

@RestController
@RequestMapping(Request.PROVIDERS)
public class ProviderController extends UUIDAbstractController<CreationProviderDTO, BasicProviderDTO, ProviderDTO> implements UUIDSortingControllerInterface<ProviderDTO>{

	ProviderService providerService;
	
	public ProviderController(ProviderService providerService) {
		super();
		this.providerService = providerService;
	}
	
	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE, Query.SORT_BY })
	public List<ProviderDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
		return this.findPaginatedAndSortedInternal(page, size, sortBy, sortOrder);
	}

	@Override
	@GetMapping(params = { Query.PAGE, Query.SIZE })
	public List<ProviderDTO> findAllPaginated(int page, int size) {
		return this.findPaginatedInternal(page, size);
	}

	@Override
	@GetMapping(params = { Query.SORT_BY })
	public List<ProviderDTO> findAllSorted(String sortBy, String sortOrder) {
		return this.findAllSortedInternal(sortBy, sortOrder);
	}

	@Override
	@GetMapping
	public List<ProviderDTO> findAll(HttpServletRequest request) {
		return findAllInternal(request);
	}
	
	@GetMapping("/{uuid}")
	public ProviderDTO findOne(@PathVariable UUID uuid) {
		return this.findOneInternal(uuid);
	}
	
	@DeleteMapping("/{uuid}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable UUID uuid) {
		this.deleteByIdInternal(uuid);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProviderDTO create(@Valid @RequestBody CreationProviderDTO provider) {
		return this.createInternal(provider);
	}
	
	@PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable UUID uuid, @Valid @RequestBody BasicProviderDTO provider) {
        updateInternal(uuid, provider);
    }

	@Override
	protected ProviderService getService() {
		return providerService;
	}

}
