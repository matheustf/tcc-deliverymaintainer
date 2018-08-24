package com.puc.tcc.deliverymaintainer.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.puc.tcc.deliverymaintainer.component.CorreiosComponent;
import com.puc.tcc.deliverymaintainer.consts.Constants;
import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;
import com.puc.tcc.deliverymaintainer.model.Entrega;
import com.puc.tcc.deliverymaintainer.model.HistoricoDeEntrega;
import com.puc.tcc.deliverymaintainer.repository.EntregaRepository;
import com.puc.tcc.deliverymaintainer.utils.Util;

@Service
public class EntregaServiceImpl implements EntregaService {

	EntregaRepository entregaRepository;
	CorreiosComponent correiosComponent;
	
	@Autowired
	public EntregaServiceImpl(EntregaRepository entregaRepository, CorreiosComponent correiosComponent) {
		this.entregaRepository = entregaRepository;
		this.correiosComponent = correiosComponent;
	}

	private Entrega consultar(String codigoDeRastreio) throws DeliveryMaintainerException {
		
		Optional<Entrega> optional = entregaRepository.findByCodigoDeRastreio(codigoDeRastreio);
		
		return validarEntrega(optional);
	}

	@Override
	public void checarEntrega(String codigoDeRastreio, StatusDaEntrega statusDaEntrega) throws DeliveryMaintainerException {
		
		boolean isNovoStatusDeEntrega = correiosComponent.isNovoStatusDeEntrega(codigoDeRastreio, statusDaEntrega);
		
		if(isNovoStatusDeEntrega) {
			updateStatusEntrega(codigoDeRastreio, statusDaEntrega);
		}	
		
	}

	private void updateStatusEntrega(String codigoDeRastreio, StatusDaEntrega statusDaEntrega) throws DeliveryMaintainerException {
		Entrega entrega = consultar(codigoDeRastreio);
		
		//TODO Criar maquina de estado para validar caminho correto
		
		HistoricoDeEntrega historicoDeEntrega = HistoricoDeEntrega
				.builder()
				.data(Util.dataNow())
				.statusDaEntrega(statusDaEntrega)
				.build();

		entrega.addHistoricoDeEntrega(historicoDeEntrega);
		entrega.setStatusDaEntrega(statusDaEntrega);
		
		entregaRepository.save(entrega);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	private Entrega validarEntrega(Optional<Entrega> optional) throws DeliveryMaintainerException {
		return Optional.ofNullable(optional).get()
		.orElseThrow(() -> new DeliveryMaintainerException(HttpStatus.NOT_FOUND, Constants.ITEM_NOT_FOUND));
	}
}
