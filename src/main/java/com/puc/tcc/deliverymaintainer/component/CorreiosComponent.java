package com.puc.tcc.deliverymaintainer.component;

import org.springframework.stereotype.Component;

import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;
import com.puc.tcc.deliverymaintainer.mockcorreios.MockCorreios;
import com.puc.tcc.deliverymaintainer.mockcorreios.MockCorreiosComponent;

@Component
public class CorreiosComponent {
	
	MockCorreiosComponent mock;
	
	public CorreiosComponent(MockCorreiosComponent mock) {
		this.mock = mock;
	}

	public String postCorreio(String codigoDeRastreio) throws DeliveryMaintainerException {
		MockCorreios mockCorreios = mock.consultarMockCorreios(codigoDeRastreio);
		return mockCorreios.getStatus();
	}
	
	public boolean isNovoStatusDeEntrega(String codigoDeRastreio, StatusDaEntrega statusDaEntrega) throws DeliveryMaintainerException {
		if(!postCorreio(codigoDeRastreio).equalsIgnoreCase(statusDaEntrega.toString())) {
			return true;
		}
		return false;
	}

}
