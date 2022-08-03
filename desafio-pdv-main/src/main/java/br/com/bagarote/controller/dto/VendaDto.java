package br.com.bagarote.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.Venda;

public class VendaDto {

	private Long id;
	private Long idEmpresa;
	private String nomeFantasia;
	private long idCliente;
	private LocalDateTime dataVenda;
	private MetodoPagamento metodoPagamento;
	private BigDecimal valorDesconto;
	private BigDecimal valorAcrescimo;
	private BigDecimal valorTotal;
	private BigDecimal valorPago;
	
	public VendaDto(Venda venda) {
		this.id = venda.getIdVenda();
		this.idEmpresa = venda.getEmpresa().getIdEmpresa();
		this.nomeFantasia = venda.getEmpresa().getNomeFantasia();
		this.idCliente = venda.getCliente().getIdCliente();
		this.dataVenda = venda.getDataVenda();
		this.metodoPagamento = venda.getMetodoPagamento();
		this.valorDesconto = venda.getValorDesconto();
		this.valorAcrescimo = venda.getValorAcrescimo();
		this.valorTotal = venda.getValorTotal();
		this.valorPago = venda.getValorPago();
		}
	
	public Long getId() {
		return id;
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
	
	public static List<VendaDto> converter(List<Venda> vendas){
		return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
	}
	
	
}
