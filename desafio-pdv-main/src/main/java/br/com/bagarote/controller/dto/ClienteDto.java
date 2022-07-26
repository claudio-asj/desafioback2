package br.com.bagarote.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.bagarote.model.Cliente;
import lombok.Data;

@Data
public class ClienteDto {
	private Long idCliente;
	private String nome;
	private String cpf;
	
	public ClienteDto( Cliente cliente ) {
		this.idCliente = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
	}
	
	
	
	public static List<ClienteDto> converter(List<Cliente> clientes){
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
}
 