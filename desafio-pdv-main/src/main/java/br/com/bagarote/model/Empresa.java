package br.com.bagarote.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.bagarote.controller.form.EmpresaForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SequenceEmpresa", sequenceName = "SEQ_EMPRESA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceEmpresa")
	@EqualsAndHashCode.Include
	private Long idEmpresa;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String responsavelLegal;
	@OneToMany(mappedBy = "empresa")
	private List<Cliente> clientes;
	@OneToMany(mappedBy = "empresa")
	private List<Produto> produtos;
	@OneToMany(mappedBy = "empresa")
	private List<Venda> vendas;
	
	public Empresa(EmpresaForm form) {
		this.nomeFantasia = form.getNomeFantasia();
		this.razaoSocial = form.getRazaoSocial();
		this.cnpj = form.getCnpj();
		this.telefone = form.getTelefone();
		this.responsavelLegal = form.getResponsavelLegal();
	}
}
