package com.example.application.adapters.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.core.model.Produto;
import com.example.application.core.usecases.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
    private ProdutoService produtoService;
	
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck() {
    	return "Olá, mundo!";
    }
  
    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable("id") Long id) {
        return produtoService.findProdutoById(id);
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAllProdutos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduto(@RequestBody Produto produto) {
        produtoService.saveProduto(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProdutoById(@PathVariable("id") Long id) {
        produtoService.deleteProdutoById(id);
    }
}
