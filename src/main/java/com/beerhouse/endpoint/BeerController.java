package com.beerhouse.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.endpoint.dto.BeerDTO;
import com.beerhouse.model.Beer;
import com.beerhouse.service.BeerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/beers", produces = { "application/json" }, consumes = { "application/json" })
public class BeerController {
	@Autowired
	private BeerService beerService;

	@ApiOperation(value = "", nickname = "beersGet", notes = "", response = Beer.class, responseContainer = "List", tags = {})
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Status 200", response = Beer.class, responseContainer = "List") })
	@GetMapping()
	public ResponseEntity<List<Beer>> beersGet() {
		List<Beer> beers = beerService.findAll();
		return new ResponseEntity<>(beers, HttpStatus.OK);
	}

	@ApiOperation(value = "", nickname = "beersIdDelete", notes = "", tags = {})
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Status 204") })
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> beersIdDelete(@ApiParam(required = true) @PathVariable("id") Integer id) {
		beerService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "", nickname = "beersIdGet", notes = "", response = Beer.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status 200", response = Beer.class) })
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Beer> beersIdGet(@ApiParam(value = "", required = true) @PathVariable("id") Integer id) {
		Beer beer = beerService.findOne(id);
		return new ResponseEntity<>(beer, HttpStatus.OK);
	}

	@ApiOperation(value = "", nickname = "beersIdPatch", notes = "", tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status 200") })
	@RequestMapping(path = "/{id}",  method = RequestMethod.PATCH)
    @Transactional(rollbackFor = Exception.class)
	public	ResponseEntity<Void> beersIdPatch(@ApiParam(value = "", required = true) @PathVariable("id") Integer id,
			@ApiParam(value = "", required = true)  @RequestBody BeerDTO body) {
		    Beer beer = beerService.findOne(id);
		    beer.setAlcoholContent(body.getAlcoholContent());
		    beer.setCategory(body.getCategory());
		    beer.setIngredients(body.getIngredients());
		    beer.setName(body.getName());
		    beer.setPrice(body.getPrice());
		    return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@ApiOperation(value = "", nickname = "beersIdPut", notes = "", tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Status 200") })
	@PutMapping(path = "/{id}")
	@Transactional(rollbackFor=Exception.class)
	ResponseEntity<Void> beersIdPut(@ApiParam(value = "", required = true) @PathVariable("id") String id,
			@ApiParam(value = "", required = true) @Valid @RequestBody Beer body){
		Beer beer = beerService.save(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "", nickname = "beersPost", notes = "", tags = {},response = Beer.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Status 201") })
	@PostMapping()
	ResponseEntity<?> beersPost(@ApiParam(value = "", required = true) @Valid @RequestBody Beer body){
		Beer beer = beerService.save(body);
		return new ResponseEntity<>(beer,HttpStatus.OK);
	}

}
