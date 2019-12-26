package com.beerhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beerhouse.model.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer>{

}
