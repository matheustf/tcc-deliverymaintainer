package com.puc.tcc.deliverymaintainer.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryMaintainerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus statusCode;
	
	private String message;
}