package com.devsuperior.DsVendas.services;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.DsVendas.dto.SaleDto;
import com.devsuperior.DsVendas.entities.Sale;
import com.devsuperior.DsVendas.repositories.SaleRepository;
import com.devsuperior.DsVendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	private SellerRepository sellerRepository;
	
	
	
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Page<SaleDto> findaLL(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDto(x));
		
	}
	

}
