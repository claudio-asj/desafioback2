package br.com.bagarote.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ClienteDto>> getAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(ClienteDto.converter(clientes));
    }
	@GetMapping("/empresa/{idEmpresa}/cliente/{idCliente}")
	public ResponseEntity<List<ClienteDto>> getByIdCliente(@PathVariable Long idCliente) {
	    List<Cliente> clientes = clienteRepository.findByEmpresaIdEmpresa(idCliente);
	    return ResponseEntity.ok(ClienteDto.converter(clientes));
    }
}
