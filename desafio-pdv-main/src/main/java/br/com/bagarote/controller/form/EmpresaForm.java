package br.com.bagarote.controller.form;

import lombok.Data;

@Data
public class EmpresaForm {
	
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String responsavelLegal;
	private Long idEmpresa;
	
	
}
