package br.com.bagarote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bagarote.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
