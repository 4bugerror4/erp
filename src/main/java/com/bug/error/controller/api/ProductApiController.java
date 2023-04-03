package com.bug.error.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.error.config.auth.PrincipalUserDetails;
import com.bug.error.entity.Employee;
import com.bug.error.entity.Product;
import com.bug.error.entity.dto.ProductDeleteDto;
import com.bug.error.entity.dto.ProductInBoundDto;
import com.bug.error.entity.dto.ProductOutBoundDto;
import com.bug.error.entity.dto.ProductSaveDto;
import com.bug.error.entity.dto.ProductUpdateDto;
import com.bug.error.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductApiController {
	
	private final ProductService productService;
	
	// 상품 추가
	@PostMapping("/product/save")
	public Product save(@RequestBody ProductSaveDto dto, @AuthenticationPrincipal PrincipalUserDetails principal) {
		
		Employee employee = principal.getEmployee();
		Product product = productService.save(dto.toEntity(employee));
		
		return product;
	}
	
	// 상품 수정
	@PutMapping("/product/update")
	public Product update(@RequestBody ProductUpdateDto dto, @AuthenticationPrincipal PrincipalUserDetails principal) {
		
		Employee employee = principal.getEmployee();
		Product product = productService.update(dto.toEntity(employee));
		
		return product;
	}
	
	// 상품 출고
	@PutMapping("/product/outbound")
	public Product outBound(@RequestBody ProductOutBoundDto dto) {
		
		Product product = productService.productOutBound(dto.getId(), dto.getCount());
		
		return product;
	}
	
	// 기존 상품 재입고
	@PutMapping("/product/inbound")
	public Product inBound(@RequestBody ProductInBoundDto dto) {
		
		Product product = productService.productInBound(dto.getId(), dto.getCount());
		
		return product;
	}
	
	// 상품 삭제
	@DeleteMapping("/product/delete")
	public void delete(@RequestBody ProductDeleteDto dto) {
		productService.delete(dto.getId());
	}

}
