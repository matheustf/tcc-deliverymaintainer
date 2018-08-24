package com.puc.tcc.deliverymaintainer.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EntregaDTO {

	private String id;

	@NotNull()
	private String idCliente;
	
	private String codigoDaEntrega;
	
	@NotNull()
	private String idFornecedor;
	
	@NotNull()
	private String idPedido;
	
	@NotNull()
	private String estimativaDeEntrega;
	
	private String statusDaEntrega;
	
	private List<HistoricoDeEntregaDTO> historicoDeEntrega;
	
}