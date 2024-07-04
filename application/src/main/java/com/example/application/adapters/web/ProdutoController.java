package com.example.application.adapters.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.core.model.Produto;
import com.example.application.core.usecases.ProdutoUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
    private ProdutoUseCase produtoUseCase;
	
	/*
	 * CADASTRA UM PRODUTO
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto saveProduto(@Valid @RequestBody Produto produto) {
		return this.produtoUseCase.save(produto);
	}
	
	
	/*
	 * ATUALIZA UM PRODUTO
	 */
	@PutMapping("/{id}")
	public Produto update(@PathVariable("id") Long id, @Valid @RequestBody Produto produto) {
		produto.setId(id);
		return this.produtoUseCase.update(produto);
	}
	
	/*
	 * BUSCA UM PRODUTO POR ID
	 */
	@GetMapping("/{id}")
	public Produto getProductById(@PathVariable("id") Long id) {
		return this.produtoUseCase.findById(id);
	}
	
	/*
	 * LISTA DE PRODUTOS
	 */
	@GetMapping
	public List<Produto> list() {
		return this.produtoUseCase.findAll();
	}
	
	
	/*
	 * EXCLUI UM PRODUTO POR ID
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		this.produtoUseCase.deleteById(id);
	}

}
