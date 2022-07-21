package br.com.bagarote.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Entity
public class ClienteEndereco implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SequenceEnderecoCliente", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceEnderecoCliente")
	@EqualsAndHashCode.Include
	private Long idEndereco;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
}
