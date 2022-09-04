package br.com.bagarote.controller.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import br.com.bagarote.model.Empresa;
import lombok.Data;
@Data
public class EmpresaDto {
	
	private Long idEmpresa;
	private String nomeFantasia;
	
	public EmpresaDto(Empresa empresa) {
		this.idEmpresa = empresa.getIdEmpresa();
		this.nomeFantasia = empresa.getNomeFantasia();
	}
	
	public EmpresaDto(Optional<Empresa> empresa) {
		// TODO Auto-generated constructor stub
	}

	public static List<EmpresaDto> converter(List<Empresa> empresas){
		return empresas.stream().map(EmpresaDto::new).collect(Collectors.toList());
	}

	

}
