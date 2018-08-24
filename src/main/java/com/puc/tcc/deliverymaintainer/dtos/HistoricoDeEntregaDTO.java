package com.puc.tcc.deliverymaintainer.dtos;

import com.puc.tcc.deliverymaintainer.enums.StatusDaEntrega;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class HistoricoDeEntregaDTO {
	
	private StatusDaEntrega statusDaEntrega;
	
	private String data;

}
