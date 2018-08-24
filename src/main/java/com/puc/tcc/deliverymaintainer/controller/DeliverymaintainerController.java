package com.puc.tcc.deliverymaintainer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.deliverymaintainer.dtos.EntregaDTO;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;
import com.puc.tcc.deliverymaintainer.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class DeliverymaintainerController {
	
	private EntregaService entregaService;

	@Autowired
	public DeliverymaintainerController(EntregaService entregaService) {
		this.entregaService = entregaService;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EntregaDTO> atualizar(@PathVariable(value = "id") String id, @RequestBody @Valid EntregaDTO entregaDTODetails) throws DeliveryMaintainerException {

		EntregaDTO entregaDTO = entregaService.atualizar(id, entregaDTODetails);

		return new ResponseEntity<EntregaDTO>(entregaDTO, HttpStatus.NO_CONTENT);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> consultar(@PathVariable(value = "id") String idEntrega) throws DeliveryMaintainerException {

		EntregaDTO entregaDTO = entregaService.consultar(idEntrega);

		return new ResponseEntity<EntregaDTO>(entregaDTO, HttpStatus.OK);
	}

}