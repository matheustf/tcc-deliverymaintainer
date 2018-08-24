package com.puc.tcc.deliverymaintainer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteAPIController {
	
	@GetMapping("v1/main")
	public ResponseEntity<String> testeAPI() {
		return new ResponseEntity<String>("API Maintainer OK", HttpStatus.OK);
	}


}
