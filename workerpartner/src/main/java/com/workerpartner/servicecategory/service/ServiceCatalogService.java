package com.workerpartner.servicecategory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workerpartner.servicecategory.response.PagedResponse;
import com.workerpartner.servicecategory.response.ServiceCategoryResponse;


public interface ServiceCatalogService {

	public PagedResponse<ServiceCategoryResponse> getActiveServices(String query, int page, int size) ;
	public List<String> getAllActiveServices();
}
