package com.beerhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<Beer> findAll(){
		return beerDAO.findAll();
	}

	public void delete(Integer id) {
		beerDAO.delete(id);		
	}

	public Beer findOne(Integer id) {
		
		return beerDAO.findOne(id);
	}

	public Beer save(Beer body) {
		
		return beerDAO.save(body);
	}

}
