package br.com.bagarote.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bagarote.controller.dto.DetalheVendaDto;
import br.com.bagarote.controller.dto.VendaDto;
import br.com.bagarote.controller.form.VendaForm;
import br.com.bagarote.model.Venda;
import br.com.bagarote.repository.VendaRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VendaController {
	
	private final VendaRepository vendaRepository;
	
	@GetMapping("/empresa/{idEmpresa}/venda")
	public ResponseEntity<List<VendaDto>> getAll() {
	    List<Venda> vendas = vendaRepository.findAll();
	    return ResponseEntity.ok(VendaDto.converter(vendas));
    }
	//não sei fazer lista por paginas
	@GetMapping("/empresa/{idEmpresa}/venda")
	public ResponseEntity<VendaDto> getByIdEmpresa(@PathVariable Long idVenda) {
	    Venda venda = vendaRepository.getById(idVenda);
	    VendaDto resposta = new VendaDto(venda);
	    return ResponseEntity.ok(resposta);
    }
	
	@GetMapping("/empresa/{idEmpresa}/venda/{idVenda}")
	public ResponseEntity<DetalheVendaDto> getDetalheVenda(@PathVariable Long idEmpresa, Long idVenda) {
		Venda venda = vendaRepository.findByEmpresaIdEmpresaAndIdVenda(idEmpresa, idVenda).get();
		DetalheVendaDto resposta = new DetalheVendaDto(venda);
		return ResponseEntity.ok(resposta);
	}

	@PostMapping
	public ResponseEntity<VendaForm> save(@RequestBody VendaForm form, UriComponentsBuilder uriBuilder){
		Venda venda = new Venda(form);
		vendaRepository.save(venda);
		
		URI uri = uriBuilder.path("/venda/{id}").buildAndExpand(venda.getIdVenda()).toUri();
		
		return ResponseEntity.created(uri).body(null);
	}
}
