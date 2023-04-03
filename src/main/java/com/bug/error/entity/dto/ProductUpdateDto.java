package com.bug.error.entity.dto;

import java.time.LocalDateTime;

import com.bug.error.entity.Employee;
import com.bug.error.entity.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductUpdateDto {
	
	private Long id;
	private String name;
	private int price;
	private int count;
	private String category;
	private LocalDateTime inbound; // 입고
	private LocalDateTime outbound; // 출고
	
	public Product toEntity(Employee employee) {
		return Product.builder()
				.id(id)
				.name(name)
				.price(price)
				.count(count)
				.category(category)
				.inbound(inbound)
				.outbound(outbound)
				.employee(employee)
				.build();
	}

}
