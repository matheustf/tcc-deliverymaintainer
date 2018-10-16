package com.puc.tcc.deliverymaintainer.service;

import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;

public interface DeliveryMaintainerService {
	
	void checarEntrega(String codigoDeRastreio, StatusDaEntrega statusDaEntrega) throws DeliveryMaintainerException;
	
}
