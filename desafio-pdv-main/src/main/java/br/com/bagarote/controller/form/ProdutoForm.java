package br.com.bagarote.controller.form;

import java.math.BigDecimal;

public class ProdutoForm {
	
	private String produto;
	private String descricao;
	private BigDecimal valorBase;
	private Long idEmpresa;
	
	
	public String getProduto() {
		return produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public BigDecimal getValorBase() {
		return valorBase;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	
	
	
	
	
}
