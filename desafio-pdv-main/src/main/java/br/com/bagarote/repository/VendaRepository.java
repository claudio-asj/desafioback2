package br.com.bagarote.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bagarote.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
	Optional<Venda> findByEmpresaIdEmpresaAndIdVenda(Long idEmpresa, Long idVenda);
}
