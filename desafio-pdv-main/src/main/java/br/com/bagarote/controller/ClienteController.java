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

import br.com.bagarote.controller.dto.ClienteDto;
import br.com.bagarote.controller.dto.DetalheClienteDto;
import br.com.bagarote.controller.form.ClienteForm;
import br.com.bagarote.model.Cliente;
import br.com.bagarote.model.Empresa;
import br.com.bagarote.repository.ClienteRepository;
import br.com.bagarote.repository.EmpresaRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {
	
	private final ClienteRepository clienteRepository;
	private final EmpresaRepository empresaRepositoy;
	
	@GetMapping("/empresa/{idEmpresa}/cliente")
	public ResponseEntity<List<ClienteDto>> getAll( @PathVariable Long idEmpresa) {
		List<Cliente> clientes = clienteRepository.findByEmpresaIdEmpresa(idEmpresa);
		return ResponseEntity.ok(ClienteDto.converter(clientes));
    }
	
	@GetMapping("/empresa/{idEmpresa}/cliente/{idCliente}")
	public ResponseEntity<?> getByIdCliente(@PathVariable Long idCliente) {
		if(clienteRepository.findById(idCliente).isPresent()) {
			Cliente cliente = clienteRepository.findById(idCliente).get();
			DetalheClienteDto resposta = new DetalheClienteDto(cliente);
			return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
	
	
	@PostMapping("/empresa/{idEmpresa}/cliente")
	public ResponseEntity<?> newCliente(@PathVariable Long idEmpresa, @RequestBody ClienteForm form){
		//ver se ja existe essa cliente
		if(clienteRepository.existsByEmpresaIdEmpresaAndCpf(form.getIdEmpresa(), form.getCpf())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
			Cliente resposta = new Cliente(form);
			Empresa empresa = empresaRepositoy.getById(form.getIdEmpresa());
			resposta.setEmpresa(empresa);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(resposta	));
		}
	}
	
	@DeleteMapping("empresa/{idEmpresa}/cliente/{idCliente}")
	public ResponseEntity<?> deleteCliente(@PathVariable Long idEmpresa, @PathVariable Long idCliente) {
		if (clienteRepository.findById(idCliente).isPresent() && empresaRepositoy.findById(idEmpresa).isPresent()) {
			clienteRepository.deleteById(idCliente);
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PutMapping("empresa/{idEmpresa}/cliente/{idCliente}")
	public ResponseEntity<?> updateCliente(@PathVariable Long idCliente, @RequestBody ClienteForm update){
		if(clienteRepository.existsByEmpresaIdEmpresaAndCpf(update.getIdEmpresa(), update.getCpf())) {
			Cliente resposta = new Cliente(update);
			Empresa empresa = empresaRepositoy.getById(update.getIdEmpresa());
			resposta.setEmpresa(empresa);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(resposta));
		}else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
