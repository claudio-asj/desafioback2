package br.com.bagarote.controller.form;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.VendaProduto;


public class VendaForm {
	
	private Long idCliente;
	private Long idEmpresa;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataVenda;
	private MetodoPagamento metodoPagamento;
	private List<VendaProdutoForm> produtos;
	

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
	public List<VendaProdutoForm> getProdutos() {
		return produtos;
	}
	
}
	
