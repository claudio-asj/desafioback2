package br.com.bagarote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bagarote.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
