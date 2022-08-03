package br.com.bagarote.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.DetalheVendaDto;
import br.com.bagarote.controller.dto.VendaDto;
import br.com.bagarote.model.Venda;
import br.com.bagarote.repository.VendaRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VendaController {
	
	private final VendaRepository vendaRepository;
	
	@GetMapping("/empresa/{idEmpresa}/venda")
	public List<VendaDto> getAll() {
	    List<Venda> vendas = vendaRepository.findAll();
	    return VendaDto.converter(vendas);
    }
	//não sei fazer lista por paginas
	@GetMapping("/empresa/{idEmpresa}/venda")
	public VendaDto getByIdEmpresa(@PathVariable Long idVenda) {
	    Venda venda = vendaRepository.getById(idVenda);
	    VendaDto resposta = new VendaDto(venda);
	    return resposta;
    }
	
	@GetMapping("/empresa/{idEmpresa}/venda/{idVenda}")
	public DetalheVendaDto getDetalheVenda(@PathVariable Long idEmpresa, Long idVenda) {
		Venda venda = vendaRepository.findByEmpresaIdEmpresaAndIdVenda(idEmpresa, idVenda).get();
		DetalheVendaDto resposta = new DetalheVendaDto(venda);
		return resposta;
	}


}
