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

	public StatusDaEntrega postCorreio(String codigoDeRastreio) throws DeliveryMaintainerException {
		MockCorreios mockCorreios = mock.consultarMockCorreios(codigoDeRastreio);
		return StatusDaEntrega.valueOf(mockCorreios.getStatus());
	}
	
}
