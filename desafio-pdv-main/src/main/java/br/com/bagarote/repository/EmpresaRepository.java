package br.com.bagarote.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bagarote.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	Optional<Empresa>  findByCnpj(String cnpj);
}
