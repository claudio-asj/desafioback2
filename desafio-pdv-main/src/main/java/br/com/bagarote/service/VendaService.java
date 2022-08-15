package br.com.bagarote.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bagarote.controller.form.VendaForm;
import br.com.bagarote.controller.form.VendaProdutoForm;
import br.com.bagarote.model.Cliente;
import br.com.bagarote.model.Empresa;
import br.com.bagarote.model.Produto;
import br.com.bagarote.model.Venda;
import br.com.bagarote.model.VendaProduto;
import br.com.bagarote.model.VendaProduto.VendaProdutoId;
import br.com.bagarote.repository.ClienteRepository;
import br.com.bagarote.repository.EmpresaRepository;
import br.com.bagarote.repository.ProdutoRepository;
import br.com.bagarote.repository.VendaProdutoRepository;
import br.com.bagarote.repository.VendaRepository;

@Service
public class VendaService {
	@Autowired
	VendaRepository vendaRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	VendaProdutoRepository vendaProdutoRepository;
	
	public Venda newVenda(VendaForm form) {
		
			Venda venda = new Venda(form);
			// cliente
			Optional<Cliente> cliente = clienteRepository.findById(form.getIdCliente());
			if(!cliente.isPresent()) {
				new Exception("cliente não encontrado");
				return null;
			}
			venda.setCliente(cliente.get());
			//empresa
			Optional<Empresa> empresa = empresaRepository.findById(form.getIdEmpresa());
			if(!empresa.isPresent()) {
				new Exception("empresa não encontrado");
				return null;
			}
			venda.setEmpresa(empresa.get());
			
			BigDecimal valorTotal = BigDecimal.ZERO;
			
			for(VendaProdutoForm produto:form.getProdutos()) {
				
				Optional<Produto> produtoBanco = produtoRepository.findById(produto.getIdProduto());
				if(!produtoBanco.isPresent()) {
					new Exception("produto não encontrado");
				}
				VendaProduto vendaProduto = new VendaProduto();
				VendaProdutoId vendaProdutoId = new VendaProdutoId();
				vendaProdutoId.setProduto(produtoBanco.get());
				vendaProdutoId.setVenda(venda);
				vendaProduto.setVendaProdutoId(vendaProdutoId);
				
				vendaProduto.setQtd(produto.getQuantidade());
				vendaProduto.setValorUnitario(produtoBanco.get().getValorBase());
				vendaProduto.setValorTotal(produtoBanco.get().getValorBase().multiply(BigDecimal.valueOf(produto.getQuantidade())));
				if(venda.getProdutos() == null) {
					venda.setProdutos(new ArrayList<VendaProduto>());
				}
				venda.getProdutos().add(vendaProduto); // "Cannot invoke \"java.util.List.add(Object)\" because \"produtos\" is null",
				
				valorTotal = valorTotal.add(vendaProduto.getValorTotal());
				System.out.println(valorTotal);
				System.out.println(vendaProduto.getValorTotal());
				
			}
			
			venda.setValorTotal(valorTotal);
			venda.setValorPago(valorTotal);
			venda.setValorDesconto(BigDecimal.ZERO);
			venda.setValorAcrescimo(BigDecimal.ZERO);
			
			vendaRepository.save(venda);
			return venda;
			
	};
}
