package com.beerhouse.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.error.ResourceNotFoundException;
import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/beers", produces = { "application/json" }, 
                                 consumes = { "application/json" })
public class BeerController {
	private final BeerRepository beerDao;

	@Autowired
	public BeerController(BeerRepository beerDao) {
		this.beerDao = beerDao;
	}

	@GetMapping
	public ResponseEntity<?> getAllBeer() {
		List<Beer> beers = beerDao.findAll();
		return new ResponseEntity<>(beers, HttpStatus.OK);
	}

	@PostMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> saveBerr(@Valid @RequestBody Beer beer) {
		beerDao.save(beer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findByIdBeer(@PathVariable("id") Integer id) {
		System.out.println("valor   " + id);
		verifyIfBeerExists(id);

		Beer beer = beerDao.getOne(id);
		return new ResponseEntity<>(beer, HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> updateBeer(@PathVariable("id") String id, @RequestBody Beer beer) {
		verifyIfBeerExists(Integer.valueOf(id));
		beerDao.save(beer);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping(path = "/{id}")
	public ResponseEntity<?> changeBeer(@PathVariable("id") String id, @RequestBody Beer beer) {
		verifyIfBeerExists(Integer.valueOf(id));
		beerDao.save(beer);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteBeer(@PathVariable("id") String id) {
		verifyIfBeerExists(Integer.valueOf(id));
		beerDao.delete(Integer.valueOf(id));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private void verifyIfBeerExists(Integer id) {
		if (beerDao.findOne(id) == null)
			throw new ResourceNotFoundException("Beer Not found by id " + id);
	}

}
