package br.com.bagarote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bagarote.model.VendaProduto;
import br.com.bagarote.model.VendaProduto.VendaProdutoId;

public interface VendaProdutoRepository extends JpaRepository<VendaProduto, VendaProdutoId>{

}
