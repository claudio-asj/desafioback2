package br.com.bagarote.controller.dto;

import br.com.bagarote.model.Empresa;
import lombok.Data;

@Data
public class DetalheEmpresaDto {
	 public Long idEmpresa;
	 public String nomeFantasia;
	 public String razaoSocial;
	 public String cnpj;
	 public String telefone;
	 public String responsaveLegal;
	 
	 public DetalheEmpresaDto(){
	 }
	 public DetalheEmpresaDto(Empresa empresa){
		 this.idEmpresa = empresa.getIdEmpresa();
		 this.nomeFantasia = empresa.getNomeFantasia();
		 this.razaoSocial = empresa.getRazaoSocial();
		 this.cnpj = empresa.getCnpj();
		 this.telefone = empresa.getTelefone();
		 this.responsaveLegal = empresa.getResponsavelLegal();
	 }
}
