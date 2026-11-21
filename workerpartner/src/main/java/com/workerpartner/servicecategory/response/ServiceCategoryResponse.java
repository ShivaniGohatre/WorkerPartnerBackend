package com.workerpartner.servicecategory.response;

public record ServiceCategoryResponse(
        Long id,
        String name,
        String iconKey,
        Integer baseRate) {
}
