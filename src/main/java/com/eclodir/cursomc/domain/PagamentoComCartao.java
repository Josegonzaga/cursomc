package com.eclodir.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.eclodir.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {}


	public PagamentoComCartao(Integer id, Pedido pedido, Date dataPagamento, EstadoPagamento estadoPagamento, Integer parcelas) {
		super(id, pedido, dataPagamento, estadoPagamento);
		
		this.numeroDeParcelas = parcelas;
	}


	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	};
	
}
