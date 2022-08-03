package br.com.bagarote.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.ClienteDto;
import br.com.bagarote.model.Cliente;
import br.com.bagarote.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {
	
	private final ClienteRepository clienteRepository;
	
	@GetMapping("/empresa/{idEmpresa}/cliente")
	public List<ClienteDto> getAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.converter(clientes);
    }
	@GetMapping("/empresa/{idEmpresa}/cliente/{idCliente}")
	public List<ClienteDto> getByIdCliente(@PathVariable Long idCliente) {
	    List<Cliente> clientes = clienteRepository.findByEmpresaIdEmpresa(idCliente);
	    return ClienteDto.converter(clientes);
    }
}
