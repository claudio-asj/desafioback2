package br.com.bagarote.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bagarote.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByEmpresaIdEmpresa(Long idEmpresa);
	Optional<Produto> findByEmpresaIdEmpresaAndIdProduto(Long idEmpresa, Long idProduto);
	Produto deleteEmpresaIdEmpresaAndIdProduto(Long idEmpresa, Long idProduto);

}
