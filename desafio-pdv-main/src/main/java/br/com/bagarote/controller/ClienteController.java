package br.com.bagarote.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.ClienteDto;
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
	public ResponseEntity<List<ClienteDto>> getAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(ClienteDto.converter(clientes));
    }
	@GetMapping("/empresa/{idEmpresa}/cliente/{idCliente}")
	public ResponseEntity<List<ClienteDto>> getByIdCliente(@PathVariable Long idCliente) {
	    List<Cliente> clientes = clienteRepository.findByEmpresaIdEmpresa(idCliente);
	    return ResponseEntity.ok(ClienteDto.converter(clientes));
    }
	
	
	@PostMapping("/empresa/{idEmpresa}/cliente")
	public ResponseEntity<?> newCliente(@PathVariable Long idEmpresa, @RequestBody ClienteForm form){
		//ver se ja existe essa cliente
		if(clienteRepository.existsByEmpresaIdEmpresaAndCpf(idEmpresa, form.getCpf())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
			Cliente resposta = new Cliente(form);
			Empresa empresa = empresaRepositoy.getById(form.getIdEmpresa());
			resposta.setEmpresa(empresa);
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(resposta	));
		}
	}
}
