package br.com.bagarote.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> newEmpresa(@RequestBody EmpresaForm form) {
		//ver se ja existe essa empresa
		if(empresaRepository.findByCnpj(form.getCnpj()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(new Empresa(form)));
		}
	    
	}
	@DeleteMapping("empresa/{idEmpresa}")
	public ResponseEntity<?> deleteEmpresa(@PathVariable Long idEmpresa){
		if(empresaRepository.findById(idEmpresa).isPresent()) {
			empresaRepository.deleteById(idEmpresa);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PutMapping("empresa/{idEmpresa}")
	public ResponseEntity<?> updateEmpresa(@PathVariable Long idEmpresa, @RequestBody EmpresaForm update) {
		if (empresaRepository.findById(idEmpresa).isPresent()) {
			Empresa empresa = empresaRepository.findById(idEmpresa).get();
			empresaRepository.save(empresa.converter(update, empresa));
			return ResponseEntity.status(HttpStatus.OK).body(empresa.converter(update, empresa));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
}
