package br.com.bagarote.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.ProdutoDto;
import br.com.bagarote.model.Produto;
import br.com.bagarote.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProdutoController {
	private final ProdutoRepository produtoRepository;
	
	@GetMapping("empresa/{idEmpresa}/produto")
	public List<ProdutoDto> getAll() {
		List<Produto> produtos = produtoRepository.findAll();
	    return ProdutoDto.converter(produtos);
    }
	@GetMapping("empresa/{idEmpresa}/produto/{idProduto}")
	public ProdutoDto getByIdProduto(@PathVariable Long idProduto) {
	    return new ProdutoDto(produtoRepository.getById(idProduto));
    }
	
}