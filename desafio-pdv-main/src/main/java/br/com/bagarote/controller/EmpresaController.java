package br.com.bagarote.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.EmpresaDto;
import br.com.bagarote.model.Empresa;
import br.com.bagarote.repository.EmpresaRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmpresaController {
	
	private final EmpresaRepository empresaRepository;
	
	@GetMapping("empresa")
	public List<EmpresaDto> getaAll() {
	    List<Empresa> empresas = empresaRepository.findAll();
	    return EmpresaDto.converter(empresas);
    }
	@GetMapping("empresa/{idEmpresa}")
	public EmpresaDto getByIdEmpresa(@PathVariable Long idEmpresa) {
	    Empresa empresa = empresaRepository.getById(idEmpresa);
	    EmpresaDto resposta = new EmpresaDto(empresa);
	    return resposta;
    }
}
