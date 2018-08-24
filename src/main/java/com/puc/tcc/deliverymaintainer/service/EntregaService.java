package com.puc.tcc.deliverymaintainer.service;

import com.puc.tcc.deliverymaintainer.dtos.EntregaDTO;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;

public interface EntregaService {
	
	EntregaDTO consultar(String id) throws DeliveryMaintainerException;
	
	EntregaDTO atualizar(String id, EntregaDTO entregaDTODetails) throws DeliveryMaintainerException;
	
}
