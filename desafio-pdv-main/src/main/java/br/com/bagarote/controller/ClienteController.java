package br.com.bagarote.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.model.Cliente;
import br.com.bagarote.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {
	
	private final ClienteRepository clienteRepository;
	
	@GetMapping("cliente")
	public ResponseEntity<?> getAll() {
	    return ResponseEntity.ok().body(clienteRepository.findAll());
    }
	@GetMapping("cliente/{idCliente}")
	public ResponseEntity<?> getByIdCliente(@PathVariable Long idCliente) {
	    return ResponseEntity.ok().body(clienteRepository.findById(idCliente).orElse(null));
    }
	@PostMapping("cliente")
	public ResponseEntity<?> create(@RequestBody Cliente createCliente) {
	    return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(createCliente));
    }
	
	@PutMapping("cliente/{idCliente}")
	public ResponseEntity<?> update(@PathVariable Long idEmpresa, @PathVariable Long idCliente, @RequestBody Cliente updateCliente) {
		Cliente cliente =  clienteRepository.findById(idCliente).orElse(null);
		if(cliente == null)
			return ResponseEntity.status(HttpStatus.OK).body(null);
		BeanUtils.copyProperties(updateCliente, cliente);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }
}
