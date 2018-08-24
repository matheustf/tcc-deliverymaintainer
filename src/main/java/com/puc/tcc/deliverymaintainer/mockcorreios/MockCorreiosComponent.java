package com.puc.tcc.deliverymaintainer.mockcorreios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.puc.tcc.deliverymaintainer.consts.Constants;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;

@Component
public class MockCorreiosComponent {

	MockCorreiosRepository mock;
	
	@Autowired
	public MockCorreiosComponent(MockCorreiosRepository mock) {
		this.mock = mock;
	}

	public MockCorreios consultarMockCorreios(String codigo) throws DeliveryMaintainerException {
		
		Optional<MockCorreios> optional = mock.findByCodigo(codigo);
		
		return validarMock(optional);
	}
	
	
	private MockCorreios validarMock(Optional<MockCorreios> optional) throws DeliveryMaintainerException {
		return Optional.ofNullable(optional).get()
		.orElseThrow(() -> new DeliveryMaintainerException(HttpStatus.NOT_FOUND, Constants.ITEM_NOT_FOUND));
	}

}
