package com.bug.error.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.error.entity.Product;
import com.bug.error.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ProductSituationService productSituationService;
	
	// 상품 추가
	@Transactional
	public Product save(Product product) {
		
		product.setInbound(LocalDateTime.now());
		Product productEntity = productRepository.save(product);
		
		productSituationService.inbount(productEntity, LocalDateTime.now(), product.getCount());
		
		return productEntity;
	}
	
	// 상품 수정
	@Transactional
	public Product update(Product product) {
		
		Product productEntity = productRepository.findById(product.getId()).orElseThrow(() -> new IllegalArgumentException("해당 번호의 제품은 존재하지 않습니다."));
		productEntity.setName(product.getName());
		productEntity.setPrice(product.getPrice());
		productEntity.setCount(product.getCount());
		productEntity.setCategory(product.getCategory());
		
		return productEntity;
	}
	
	// 기존 상품 재입고
	@Transactional
	public Product productInBound(Long id, int count) {
		
		Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" 해당 번호의 제품은 존재하지 않습니다."));
		
		int originalCount = product.getCount() + count;
		product.setCount(originalCount);
		
		productSituationService.inbount(product, LocalDateTime.now(), count);
		
		return product;
	}
	
	// 상품 출고
	@Transactional
	public Product productOutBound(Long id, int count) {
		
		Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" 해당 번호의 제품은 존재하지 않습니다."));
		
		int originalCount = product.getCount() - count;
		product.setCount(originalCount);
		
		product.setOutbound(LocalDateTime.now());
		
		productSituationService.outbound(product, LocalDateTime.now(), count);
		
		return product;
	}
	
	// 상품 삭제
	@Transactional
	public void delete(Long id) {
		
		productRepository.deleteById(id);
	}
	
}
