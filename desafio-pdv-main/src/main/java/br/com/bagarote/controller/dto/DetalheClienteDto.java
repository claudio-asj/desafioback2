package br.com.bagarote.controller.dto;

import br.com.bagarote.model.Cliente;
import lombok.Data;

@Data
public class DetalheClienteDto {
	private Long idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	
	public DetalheClienteDto( Cliente cliente ) {
		this.idCliente = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
	}
}
