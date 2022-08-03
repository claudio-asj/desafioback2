package br.com.bagarote.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("empresa")
	public ResponseEntity<?> create(@RequestBody br.com.bagarote.model.Empresa createEmpresa) {
	    return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(createEmpresa));
    }
	@PutMapping("empresa/{idEmpresa}")
	public ResponseEntity<?> update(@PathVariable Long idEmpresa, @RequestBody Empresa updateEmpresa) {
		Empresa empresa = empresaRepository.findById(idEmpresa).orElse(null);
		BeanUtils.copyProperties(updateEmpresa, empresa);
	    return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
    }
}
