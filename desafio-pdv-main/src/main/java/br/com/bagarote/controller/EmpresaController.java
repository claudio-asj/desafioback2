package br.com.bagarote.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.EmpresaDto;
import br.com.bagarote.controller.form.EmpresaForm;
import br.com.bagarote.model.Empresa;
import br.com.bagarote.repository.EmpresaRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EmpresaController {
	
	private final EmpresaRepository empresaRepository;
	
	@GetMapping("empresa")
	public ResponseEntity<List<EmpresaDto>> getaAll() {
	    List<Empresa> empresas = empresaRepository.findAll();
	    return ResponseEntity.ok(EmpresaDto.converter(empresas));
    }
	@GetMapping("empresa/{idEmpresa}")
	public ResponseEntity<EmpresaDto> getByIdEmpresa(@PathVariable Long idEmpresa) {
	    Empresa empresa = empresaRepository.getById(idEmpresa);
	    EmpresaDto resposta = new EmpresaDto(empresa);
	    return ResponseEntity.ok(resposta);
    }
	@PostMapping("/empresa")
	public ResponseEntity<?> create(@RequestBody EmpresaForm form) {
		//checar se ja existe essa empresa
		if(empresaRepository.findByCnpj(form.getCnpj()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(new Empresa(form)));
		}
	    
	}
}
