package br.com.bagarote.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bagarote.controller.form.VendaProdutoForm;
import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.Venda;
import br.com.bagarote.model.VendaProduto;

public class DetalheVendaDto {
	
	private Long idVenda;
	private Long idEmpresa;
	private String nomeFantasia;
	private long idCliente;
	private LocalDateTime dataVenda;
	private MetodoPagamento metodoPagamento;
	private BigDecimal valorDesconto;
	private BigDecimal valorAcrescimo;
	private BigDecimal valorTotal;
	private BigDecimal valorPago;
	private List<VendaProdutoForm> produtos;
	
	public DetalheVendaDto(Venda venda) {
		this.idVenda = venda.getIdVenda();
		this.idEmpresa = venda.getEmpresa().getIdEmpresa();
		this.nomeFantasia = venda.getEmpresa().getNomeFantasia();
		this.idCliente = venda.getCliente().getIdCliente();
		this.dataVenda = venda.getDataVenda();
		this.metodoPagamento = venda.getMetodoPagamento();
		this.valorDesconto = venda.getValorDesconto();
		this.valorAcrescimo = venda.getValorAcrescimo();
		this.valorTotal = venda.getValorTotal();
		this.valorPago = venda.getValorPago();
		
		//precisocomolcar um for na venda pra virar o dto
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public BigDecimal getValorAcrescimo() {
		return valorAcrescimo;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public List<VendaProdutoForm> getProdutos() {
		return produtos;
	}
	
	public static List<DetalheVendaDto> converter(List<Venda> vendas){
		return vendas.stream().map(DetalheVendaDto::new).collect(Collectors.toList());
	}

}
