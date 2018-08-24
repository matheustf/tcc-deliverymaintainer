package com.puc.tcc.deliverymaintainer.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.puc.tcc.deliverymaintainer.consts.Constants;
import com.puc.tcc.deliverymaintainer.dtos.EntregaDTO;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;
import com.puc.tcc.deliverymaintainer.model.Entrega;
import com.puc.tcc.deliverymaintainer.repository.EntregaRepository;

@Service
public class EntregaServiceImpl implements EntregaService {

	EntregaRepository entregaRepository;
	
	@Autowired
	public EntregaServiceImpl(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}

	@Override
	public EntregaDTO consultar(String id) throws DeliveryMaintainerException {
		
		Optional<Entrega> optional = entregaRepository.findById(id);
		Entrega entrega = validarEntrega(optional);
		
		EntregaDTO entregaDTO = modelMapper().map(entrega, EntregaDTO.class);
		
		return entregaDTO;
	}

	@Override
	public EntregaDTO atualizar(String id, EntregaDTO entregaDTODetails) throws DeliveryMaintainerException {
		
		Optional<Entrega> optional = entregaRepository.findById(id);
		Entrega entrega = validarEntrega(optional);
		
		Entrega entregaDetails = modelMapper().map(entregaDTODetails, Entrega.class);

		entrega = entrega.update(entrega, entregaDetails);

		entregaRepository.save(entrega);

		EntregaDTO entregaDTO = modelMapper().map(entrega, EntregaDTO.class);

		return entregaDTO;
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
