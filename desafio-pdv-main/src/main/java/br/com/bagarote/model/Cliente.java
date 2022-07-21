package br.com.bagarote.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SequenceCliente", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceCliente")
	@EqualsAndHashCode.Include
	private Long idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	@ManyToOne
	@JoinColumn(name = "ID_EMPRESA")
	private Empresa empresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<ClienteEndereco> enderecos;

}
