package br.com.bagarote.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import br.com.bagarote.model.Empresa;

public class EmpresaDto {
	
	private Long id;
	private String nomeFantasia;
	
	public EmpresaDto(Empresa empresa) {
		this.id = empresa.getIdEmpresa();
		this.nomeFantasia = empresa.getNomeFantasia();
	}
	
	public EmpresaDto(Optional<Empresa> empresa) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public String getNomeFanasia() {
		return nomeFantasia;
	}
	
	public static List<EmpresaDto> converter(List<Empresa> empresas){
		return empresas.stream().map(EmpresaDto::new).collect(Collectors.toList());
	}

	

}
