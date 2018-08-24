package com.puc.tcc.deliverymaintainer.mockcorreios;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class MockCorreios {

	@NotNull
	private String codigo;
	
	@NotNull
	private String status;

}