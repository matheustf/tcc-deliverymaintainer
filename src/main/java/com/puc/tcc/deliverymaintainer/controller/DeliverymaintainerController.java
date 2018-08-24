package com.puc.tcc.deliverymaintainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.deliverymaintainer.dtos.EntregaDTO;
import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;
import com.puc.tcc.deliverymaintainer.service.EntregaService;

@RestController
@RequestMapping("/checarEntrega")
public class DeliverymaintainerController {

	private EntregaService entregaService;

	@Autowired
	public DeliverymaintainerController(EntregaService entregaService) {
		this.entregaService = entregaService;
	}

	@PostMapping("/checarEntrega/{codigoRastreio}/{statusDaEntrega}")
	public ResponseEntity<EntregaDTO> checarEntrega(@PathVariable("codigoDeRastreio") String codigoDeRastreio,
			@PathVariable("statusDaEntrega") StatusDaEntrega statusDaEntrega) throws DeliveryMaintainerException {

		entregaService.checarEntrega(codigoDeRastreio,statusDaEntrega);

		return new ResponseEntity<EntregaDTO>(HttpStatus.OK);
	}

}