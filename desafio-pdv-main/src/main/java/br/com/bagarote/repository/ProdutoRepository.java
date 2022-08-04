package br.com.bagarote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bagarote.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
