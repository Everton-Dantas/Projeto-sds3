package com.devsuperior.DsVendas.services;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.DsVendas.dto.SellerDto;
import com.devsuperior.DsVendas.entities.Seller;
import com.devsuperior.DsVendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDto> findaLL(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDto(x)).collect(Collectors.toList());
		
	}
	

}
