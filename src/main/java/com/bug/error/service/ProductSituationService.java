package com.bug.error.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bug.error.entity.Product;
import com.bug.error.entity.ProductSituation;
import com.bug.error.repository.ProductSituationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductSituationService {
	
	private final ProductSituationRepository productSituationRepository;
	
	@Transactional
	public List<ProductSituation> getSitutations() {
		
		List<ProductSituation> situations = productSituationRepository.findAll();
		
		return situations;
	}
	
	@Transactional
	public void inbount(Product product, LocalDateTime inbount, int inbountCount) {
		
		ProductSituation productSituation = new ProductSituation();
		productSituation.setProcut(product);
		productSituation.setInbound(inbount);
		productSituation.setInboundCount(inbountCount);
		
		productSituationRepository.save(productSituation);
		
	}
	
	@Transactional
	public void outbound(Product product, LocalDateTime outbound, int outboundCount) {
		
		ProductSituation productSituation = new ProductSituation();
		productSituation.setProcut(product);
		productSituation.setOutbound(outbound);
		productSituation.setOutboundCount(outboundCount);
		
		productSituationRepository.save(productSituation);
		
	}
	
}
