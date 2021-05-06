package com.devsuperior.DsVendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.DsVendas.dto.SaleSucessDto;
import com.devsuperior.DsVendas.dto.SaleSumDto;
import com.devsuperior.DsVendas.entities.Sale;


public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.devsuperior.DsVendas.dto.SaleSumDto(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDto> amountGroupedBySeller();
	
	
	
	@Query("SELECT new com.devsuperior.DsVendas.dto.SaleSucessDto(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDto> sucessGroupedBySeller();
	
}
