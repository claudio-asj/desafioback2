package br.com.bagarote.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.bagarote.controller.form.VendaForm;
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
public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SequenceVenda", sequenceName = "SEQ_VENDA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceVenda")
	@EqualsAndHashCode.Include
	private Long idVenda;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "ID_EMPRESA")
	private Empresa empresa;
	@Column(name = "DT_VENDA")
	private LocalDateTime dataVenda;

	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	private BigDecimal valorAcrescimo;
	private BigDecimal valorPago;
	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodoPagamento;
	
	@OneToMany
	private List<VendaProduto> produtos;

	public Venda(VendaForm form) {
		//ClienteRepository clienteRepository;
		//this.cliente = clienteRepository.getById(form.getIdCliente());
		this.dataVenda = form.getDataVenda();
		this.metodoPagamento = form.getMetodoPagamento();
		this.produtos = form.getProdutos();
	}
	
	
}
