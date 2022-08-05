package br.com.bagarote.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VendaProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@EqualsAndHashCode.Include
	private VendaProdutoId vendaProdutoId;
	private BigDecimal valorUnitario;
	private Integer qtd;
	private BigDecimal valorTotal;

	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public static class VendaProdutoId implements Serializable {
		private static final long serialVersionUID = 1L;
		@ManyToOne
		@JoinColumn(name = "ID_VENDA")
		private Venda venda;
		@ManyToOne
		@JoinColumn(name = "ID_PRODUTO")
		private Produto produto;
	}
	
}
