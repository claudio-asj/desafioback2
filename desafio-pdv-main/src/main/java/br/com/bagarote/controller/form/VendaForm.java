package br.com.bagarote.controller.form;

import java.time.LocalDateTime;
import java.util.List;
import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.VendaProduto;

public class VendaForm {
	
	private Long idVenda;
	private Long idCliente;
	private LocalDateTime dataVenda;
	private MetodoPagamento metodoPagamento;
	private List<VendaProduto> produtos;
	
	
	public Long getIdVenda() {
		return idVenda;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public LocalDateTime getDataVenda() {
		return dataVenda;
	}
	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}
	public List<VendaProduto> getProdutos() {
		return produtos;
	}
}
	
