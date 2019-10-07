package com.beerhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.beerhouse.model.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer>{

}
