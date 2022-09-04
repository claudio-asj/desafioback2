package br.com.bagarote.controller.form;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoForm {
	
	private String produto;
	private String descricao;
	private BigDecimal valorBase;
	private Long idEmpresa;
	private String imagemProduto;
	
	
	
	
	
	
}
