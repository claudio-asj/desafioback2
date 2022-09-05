package br.com.bagarote.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<ProdutoDto>> getAll(@PathVariable Long idEmpresa) {
		List<Produto> produtos = produtoRepository.findByEmpresaIdEmpresa(idEmpresa);
	    return ResponseEntity.ok(ProdutoDto.converter(produtos));
    }
	@GetMapping("empresa/{idEmpresa}/produto/{idProduto}")
	public ResponseEntity<DetalheProdutoDto> getByIdProduto(@PathVariable Long idProduto) {
		if (produtoRepository.findById(idProduto).isPresent()) {
			Produto produto = produtoRepository.getById(idProduto);
			DetalheProdutoDto resposta = new DetalheProdutoDto();
			resposta.converter(produto);
		    return ResponseEntity.ok(resposta);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
    }
	
	@DeleteMapping("empresa/{idEmpresa}/produto/{idProduto}")
	public ResponseEntity<?> deleteProduto(@PathVariable Long idEmpresa, @PathVariable Long idProduto){
		if (produtoRepository.findByEmpresaIdEmpresaAndIdProduto(idEmpresa, idProduto).isPresent()) {
			Produto produto = produtoRepository.findByEmpresaIdEmpresaAndIdProduto(idEmpresa, idProduto).get();
			produtoRepository.delete(produto);
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@PostMapping("empresa/{idEmpresa}/produto")
	public ResponseEntity<?> newProduto(@PathVariable Long idEmpresa , @RequestBody ProdutoForm form){
		if (empresaRepository.findById(idEmpresa).isPresent() ){
			Produto resposta = new Produto(form);
			Empresa empresa = empresaRepository.getById(form.getIdEmpresa());
			resposta.setEmpresa(empresa);
			produtoRepository.save(resposta);
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
				
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		}
		
	}
	
	@PutMapping("empresa/{idEmpresa}/produto/{idProduto}")
	public ResponseEntity<?> updateProduto(@PathVariable Long idProduto,@PathVariable Long idEmpresa, @RequestBody ProdutoForm form){
		if(produtoRepository.findByEmpresaIdEmpresaAndIdProduto(idEmpresa, idProduto).isPresent()) {
			Produto resposta = new Produto(form);
			Empresa empresa = empresaRepository.getById(form.getIdEmpresa());
			resposta.setEmpresa(empresa);
			resposta.setIdProduto(idProduto);
			produtoRepository.save(resposta);
			return ResponseEntity.ok().body(null);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
}