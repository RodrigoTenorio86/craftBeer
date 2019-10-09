package com.beerhouse;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BeerRepositoryTest {
	
	@Autowired
	private BeerRepository beerDao;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private Beer beer;

}
