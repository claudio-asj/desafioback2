package br.com.bagarote.controller.dto;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bagarote.model.Produto;
import lombok.Data;
@Data
public class ProdutoDto {
	
	private Long idProduto;
	private String produto;
	private String descricao;
	private BigDecimal valorBase;
	private String imagemProduto;
	private Long idEmpresa;
	
	
	
	public ProdutoDto(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.produto = produto.getProduto();
		this.descricao = produto.getDescricao();
		this.valorBase = produto.getValorBase();
		if(produto.getImagemProduto()!=null) {
			this.imagemProduto = Base64.getEncoder().encodeToString(produto.getImagemProduto());
		}
		
		this.idEmpresa = produto.getEmpresa().getIdEmpresa();
	}
	
	
	
	public static List<ProdutoDto> converter(List<Produto> produtos){
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
}
