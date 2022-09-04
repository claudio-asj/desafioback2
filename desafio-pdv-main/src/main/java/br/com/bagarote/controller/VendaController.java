package br.com.bagarote.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.DetalheVendaDto;
import br.com.bagarote.controller.dto.VendaDto;
import br.com.bagarote.controller.form.VendaForm;
import br.com.bagarote.model.Venda;
import br.com.bagarote.repository.VendaRepository;
import br.com.bagarote.service.VendaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VendaController {
	
	private final VendaRepository vendaRepository;
//	private final ClienteRepository clienteRepository;
//	private final EmpresaRepository empresaRepository;
	private final VendaService vendaService;
	
	
	@GetMapping("/empresa/{idEmpresa}/venda")
	public ResponseEntity<List<VendaDto>> getAll( @PathVariable Long idEmpresa ) {
	    List<Venda> vendas = vendaRepository.findByEmpresaIdEmpresa(idEmpresa);
	    return ResponseEntity.ok(VendaDto.converter(vendas));
    }
	
	@GetMapping("/empresa/{idEmpresa}/venda/{idVenda}")
	public ResponseEntity<DetalheVendaDto> getDetalheVenda(@PathVariable Long idEmpresa, @PathVariable Long idVenda) {
		
		if(vendaRepository.findByEmpresaIdEmpresaAndIdVenda(idEmpresa, idVenda).isPresent()) {
			Venda venda = vendaRepository.findByEmpresaIdEmpresaAndIdVenda(idEmpresa, idVenda).get();
			DetalheVendaDto resposta = new DetalheVendaDto(venda);
			return ResponseEntity.ok(resposta);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}

	@PostMapping("/empresa/{idEmpresa}/venda")
	public ResponseEntity<?> newVenda(@RequestBody VendaForm form, @PathVariable Long idEmpresa){
		//checar idEmpresa uri e objeto
		Venda venda = vendaService.newVenda(form);
		DetalheVendaDto resposta = new DetalheVendaDto(venda);
		//(new DetalheVendaDto(vendaService.newVenda(form))
		return ResponseEntity.status(HttpStatus.CREATED).body(resposta);

	}
	
	@DeleteMapping("/empresa/{idEmpresa}/venda/{idVenda}")
	public ResponseEntity<?> deleteVenda(@PathVariable Long idEmpresa, @PathVariable Long idVenda) {
		if(vendaRepository.findByEmpresaIdEmpresaAndIdVenda(idEmpresa, idVenda).isPresent()) {
			vendaRepository.deleteById(idVenda);
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
}
