package br.com.bagarote.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	private List<VendaProdutoDto> produtos;
	
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

		//ainda to usando o List do java
		for(VendaProduto produto:venda.getProdutos()) {
			
			VendaProdutoDto novo = new VendaProdutoDto();
			novo.setQtd(produto.getQtd());
			//novo.setIdVendaProduto(produto.getVendaProdutoId());
			
			novo.setIdProduto(produto.getVendaProdutoId().getProdutoid());
			
			if(this.produtos == null) {
				this.produtos = new ArrayList<VendaProdutoDto>();
			}
			
			this.produtos.add(novo);//preciso pegar o id do produto !!!!
		}
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

	public List<VendaProdutoDto> getProdutos() {
		return produtos;
	}
	
	public static List<DetalheVendaDto> converter(List<Venda> vendas){
		return vendas.stream().map(DetalheVendaDto::new).collect(Collectors.toList());
	}

}
