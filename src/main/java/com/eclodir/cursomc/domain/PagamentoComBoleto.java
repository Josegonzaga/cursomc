package com.eclodir.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.eclodir.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;

	@JsonFormat (pattern="dd/MM/yyy")
	private Date dataVencimento;
	@JsonFormat (pattern="dd/MM/yyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {}

	

	public PagamentoComBoleto(Integer id, Pedido pedido, Date dataPagamento, EstadoPagamento estadoPagamento, Date dataVencimento) {
		super(id, pedido, dataPagamento, estadoPagamento);
		this.dataVencimento = dataVencimento;

	}



	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	};
	
	
	
	
}
