package com.devsuperior.DsVendas.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.DsVendas.dto.SaleDto;
import com.devsuperior.DsVendas.dto.SaleSucessDto;
import com.devsuperior.DsVendas.dto.SaleSumDto;
import com.devsuperior.DsVendas.entities.Sale;
import com.devsuperior.DsVendas.repositories.SaleRepository;
import com.devsuperior.DsVendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	
	private SellerRepository sellerRepository;
	
	
	
  @Transactional(readOnly = true)
	public Page<SaleDto> findaLL(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDto(x));
		
	}
    @Transactional(readOnly = true)
  public List<SaleSumDto> amoutGroupedBySeller() {
    	return repository.amountGroupedBySeller();
    }
    @Transactional(readOnly = true)
    public List<SaleSucessDto> sucessGroupedBySeller() {
      	return repository.sucessGroupedBySeller();
      }
} 
