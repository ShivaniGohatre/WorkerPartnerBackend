package com.workerpartner.servicecategory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workerpartner.servicecategory.response.PagedResponse;
import com.workerpartner.servicecategory.response.ServiceCategoryResponse;
import com.workerpartner.servicecategory.service.ServiceCatalogService;

@RestController
@RequestMapping("/api")
public class ServiceCatalogController {

	ServiceCatalogService servicecatalogservice;
	
	ServiceCatalogController(ServiceCatalogService servicecatalogservice)
	{
		this.servicecatalogservice= servicecatalogservice;
	}
	
	@GetMapping("/find/catalogservice")
	public ResponseEntity<PagedResponse<ServiceCategoryResponse> > findCatalogServices(@RequestParam String query, @RequestParam int page, @RequestParam int size)
	
	{
		PagedResponse<ServiceCategoryResponse> result = servicecatalogservice.getActiveServices(query, page, size);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
		
	}
	
	@GetMapping("/find/allcatalogservice")
	public ResponseEntity<List<String>> findAllCatalogServices()
	{
		List<String> result = servicecatalogservice.getAllActiveServices();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);

	}
}
