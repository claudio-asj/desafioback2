package br.com.bagarote.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bagarote.model.Produto;

public class ProdutoDto {
	
	private Long idProduto;
	private String produto;
	private String descricao;
	private BigDecimal valorBase;
	private byte[] imagemProduto;
	private Long idEmpresa;
	
	
	
	public ProdutoDto(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.produto = produto.getProduto();
		this.descricao = produto.getDescricao();
		this.valorBase = produto.getValorBase();
		this.imagemProduto = produto.getImagemProduto();
		this.idEmpresa = produto.getEmpresa().getIdEmpresa();
	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	public String getProduto() {
		return produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public BigDecimal getValorBase() {
		return valorBase;
	}
	public byte[] getImagemProduto() {
		return imagemProduto;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	
	public static List<ProdutoDto> converter(List<Produto> produtos){
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
}
