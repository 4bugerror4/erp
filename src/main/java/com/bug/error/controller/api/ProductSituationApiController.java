package com.bug.error.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.error.entity.ProductSituation;
import com.bug.error.service.ProductSituationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductSituationApiController {
	
	private final ProductSituationService productSituationService;
	
	@GetMapping("/product/situations")
	public List<ProductSituation> situations() {
		
		List<ProductSituation> situations = productSituationService.getSitutations();
		
		return situations;
		
	}

}
