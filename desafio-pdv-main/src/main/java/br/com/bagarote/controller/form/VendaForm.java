package br.com.bagarote.controller.form;

import java.time.LocalDateTime;
import java.util.List;
import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.VendaProduto;


public class VendaForm {
	
	private Long idCliente;
	private Long idEmpresa;
	private LocalDateTime dataVenda;
	private MetodoPagamento metodoPagamento;
	private List<VendaProduto> produtos;
	

	public Long getIdCliente() {
		return idCliente;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
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
	
