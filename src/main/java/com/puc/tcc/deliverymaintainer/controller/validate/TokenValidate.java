package com.puc.tcc.deliverymaintainer.controller.validate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.puc.tcc.deliverymaintainer.consts.Constants;
import com.puc.tcc.deliverymaintainer.exceptions.DeliveryMaintainerException;
import com.puc.tcc.deliverymaintainer.utils.Util;

@Component
public class TokenValidate {

	public void tokenValidate(String token) throws DeliveryMaintainerException {
		String idCadastro = Util.getPagameterToken(token, "idCadastro");

		if (StringUtils.isBlank(idCadastro)) {
			throw new DeliveryMaintainerException(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED);
		}

	}
	
	public void tokenSimpleValidate(String token) throws DeliveryMaintainerException {
		if (StringUtils.isBlank(token)) {
			throw new DeliveryMaintainerException(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED);
		}
	}

	public void tokenValidateCliente(String token, String idCliente) throws DeliveryMaintainerException {
		String idCadastro = Util.getPagameterToken(token, "idCadastro");

		if (!isTokenCorreto(idCadastro, idCliente)) {
			throw new DeliveryMaintainerException(HttpStatus.UNAUTHORIZED, Constants.UNAUTHORIZED);
		}

	}

	private boolean isTokenCorreto(String idCadastro, String idCliente) {
		return StringUtils.isNotBlank(idCadastro) && idCadastro.equals(idCliente);
	}

}
