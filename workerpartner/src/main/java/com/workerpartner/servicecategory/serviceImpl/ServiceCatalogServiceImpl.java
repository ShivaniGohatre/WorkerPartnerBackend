package com.workerpartner.servicecategory.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.workerpartner.servicecategory.entity.ServiceCategory;
import com.workerpartner.servicecategory.repository.ServiceCategoryRepository;
import com.workerpartner.servicecategory.response.PagedResponse;
import com.workerpartner.servicecategory.response.ServiceCategoryResponse;
import com.workerpartner.servicecategory.service.ServiceCatalogService;

@Service
public class ServiceCatalogServiceImpl implements ServiceCatalogService {

	
	private static final int MAX_PAGE_SIZE = 50;
	 
    private final ServiceCategoryRepository repository;
 
    public ServiceCatalogServiceImpl(ServiceCategoryRepository repository) {
        this.repository = repository;
    }
	@Override
	public PagedResponse<ServiceCategoryResponse> getActiveServices(String query, int page, int size) {
		
		int safePage = Math.max(page, 0);
		
		int safeSize = size; // ✅ FIX: Capture the incoming size first
	    
	    if(safeSize < 1) {
	        safeSize = 1;
	    }
	    else if (safeSize > MAX_PAGE_SIZE) {
	        safeSize = MAX_PAGE_SIZE;
	    }
		Sort sort = Sort.by(Sort.Order.asc("displayOrder"),(Sort.Order.asc("id")));
		
		Pageable pageable = PageRequest.of(safePage, safeSize, sort);
		
		Page<ServiceCategory> data;
		
		if(query.isBlank() || query == null)
		{
			  data = repository.findByActiveTrue(pageable);
		}
		else
		{
			  data = repository.findByActiveTrueAndNameContainingIgnoreCase(query, pageable);
		}
		
		List<ServiceCategoryResponse> serviceList = new ArrayList<>();
		
		for(ServiceCategory serviceCategory : data.getContent())
		{
		   ServiceCategoryResponse serviceCategoryResponse = new ServiceCategoryResponse(
				   serviceCategory.getId(), serviceCategory.getName(), serviceCategory.getIconKey(), serviceCategory.getBaseRate());
		   
		   serviceList.add(serviceCategoryResponse);
		   
		   
		}
		Page<ServiceCategoryResponse> dtoPage = new PageImpl<>(serviceList,pageable,data.getTotalElements()); 
		
		PagedResponse<ServiceCategoryResponse> response = PagedResponse.from(dtoPage);

		return response;
	}
	@Override
	public List<String> getAllActiveServices() {
		
		List<String> result = repository.findAllServiceCategory();
		
		return result;
	}

	
}
