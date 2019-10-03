package com.beerhouse.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.model.Beer;

@RestController
@RequestMapping(path = "beers", consumes = "application/json"
                              , produces = "application/json")
public class BeerController {
	
	
	@GetMapping
	public ResponseEntity<?> getAllBeer() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveBerr(@RequestBody Beer beer){
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<?> findByIdBeer(@PathVariable("id") String id ){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> updateBeer(@PathVariable("id") String id, @RequestBody Beer beer){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping(path="/{id}")
	public ResponseEntity<?> changeBeer(@PathVariable("id") String id, @RequestBody Beer beer){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteBeer(@PathVariable("id") String id){
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
