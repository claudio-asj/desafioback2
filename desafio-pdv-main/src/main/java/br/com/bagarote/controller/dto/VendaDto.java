package br.com.bagarote.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bagarote.model.MetodoPagamento;
import br.com.bagarote.model.Venda;
import lombok.Data;

@Data
public class VendaDto {

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
	private String nomeCliente;
	
	
	public VendaDto(Venda venda) {
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
		this.nomeCliente = venda.getCliente().getNome();
		}
	

	public static List<VendaDto> converter(List<Venda> vendas){
		return vendas.stream().map(VendaDto::new).collect(Collectors.toList());
	}
	
	
}
