package com.beerhouse.endpoint;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.config.security.TokenService;
import com.beerhouse.endpoint.dto.LoginForm;
import com.beerhouse.endpoint.dto.TokenDto;

@RestController
@RequestMapping(path="/v1/auth", produces = { "application/json" }, consumes = { "application/json" })
public class AutenticacaoController {
	@Autowired
	private AuthenticationManager authManager;
	
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		
		
		
		try {
			UsernamePasswordAuthenticationToken dadaosLogin=form.converter();
			
			Authentication authentication = authManager.authenticate(dadaosLogin);
		
			String token = tokenService.gerarToken(authentication);
		
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		
		}catch(AuthenticationException e) {
			
			return ResponseEntity.badRequest().build();
			
		}
	}
}
