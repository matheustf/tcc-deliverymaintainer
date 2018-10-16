package com.puc.tcc.deliverymaintainer.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.deliverymaintainer.dtos.CheckFeignDTO;
import com.puc.tcc.deliverymaintainer.dtos.EntregaDTO;
import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;
import com.puc.tcc.deliverymaintainer.service.DeliveryMaintainerService;

@RestController
@RequestMapping("/checarEntrega")
public class DeliverymaintainerController {

	private DeliveryMaintainerService entregaService;

	@Autowired
	public DeliverymaintainerController(DeliveryMaintainerService deliveryMaintainerService) {
		this.entregaService = deliveryMaintainerService;
	}

	@PostMapping("")
	public ResponseEntity<EntregaDTO> checarEntrega(@RequestBody CheckFeignDTO check)
			throws DeliveryMaintainerException {
		System.out.println("Execute Delivery Maintainer");
		entregaService.checarEntrega(check.getCodigoDeRastreio(), StatusDaEntrega.valueOf(check.getStatusDaEntrega()));

		return new ResponseEntity<EntregaDTO>(HttpStatus.OK);
	}

}