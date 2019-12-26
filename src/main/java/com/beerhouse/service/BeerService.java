package com.beerhouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;

@Service
public class BeerService {
	
	private final BeerRepository beerDAO;
	
	@Autowired
	public BeerService(BeerRepository beerDAO) {
		this.beerDAO=beerDAO;
	}
	
	public Page<Beer> findAll(Pageable paginacao){
		return beerDAO.findAll(paginacao);
	}

	public void delete(Integer id) {
		beerDAO.deleteById(id);	
	}

	public Optional< Beer> findById(Integer id) {
		
		return beerDAO.findById(id);
	}

	public Beer save(Beer body) {
		
		return beerDAO.save(body);
	}

}
