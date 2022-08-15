package br.com.bagarote.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bagarote.controller.dto.DetalheProdutoDto;
import br.com.bagarote.controller.dto.ProdutoDto;
import br.com.bagarote.controller.form.ProdutoForm;
import br.com.bagarote.model.Empresa;
import br.com.bagarote.model.Produto;
import br.com.bagarote.repository.EmpresaRepository;
import br.com.bagarote.repository.ProdutoRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProdutoController {
	private final ProdutoRepository produtoRepository;
	private final EmpresaRepository empresaRepository;
	
	@GetMapping("empresa/{idEmpresa}/produto")
	public ResponseEntity<List<ProdutoDto>> getAll() {
		List<Produto> produtos = produtoRepository.findAll();
	    return ResponseEntity.ok(ProdutoDto.converter(produtos));
    }
	@GetMapping("empresa/{idEmpresa}/produto/{idProduto}")
	public ResponseEntity<DetalheProdutoDto> getByIdProduto(@PathVariable Long idProduto) {
		Produto produto = produtoRepository.getById(idProduto);
		DetalheProdutoDto resposta = new DetalheProdutoDto();
		resposta.converter(produto);
	    return ResponseEntity.ok(resposta);
    }
	
	@PostMapping("empresa/{idEmpresa}/produto")
	public ResponseEntity<?> newProduto(@PathVariable Long idEmpresa , @RequestBody ProdutoForm form){
		Produto resposta = new Produto(form);
		Empresa empresa = empresaRepository.getById(form.getIdEmpresa());
		resposta.setEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(resposta));
	}
	
}