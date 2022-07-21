package br.com.bagarote.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bagarote.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByEmpresaIdEmpresa(Long idEmpresa);

	boolean existsByEmpresaIdEmpresaAndCpf(Long idEmpresa, String cpf);

	Page<Cliente> findByEmpresaIdEmpresa(Long idEmpresa, Pageable pageRequest);

	Optional<Cliente> findByEmpresaIdEmpresaAndIdCliente(Long idEmpresa, Long idCliente);

}
