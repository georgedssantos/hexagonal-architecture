package com.example.application.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.core.model.Produto;
import com.example.application.core.ports.ProdutoPort;
import com.example.application.core.usecases.ProdutoUseCase;

@Service
public class ProdutoService implements ProdutoUseCase {
	
	@Autowired
	private ProdutoPort produtoPort;

	@Override
    public Produto save(Produto produto) {
		return this.produtoPort.save(produto);
    }

	@Override
    public void deleteById(Long id) {
		this.produtoPort.deleteById(id);
    }

	@Override
	public Produto update(Produto product) {		
		return this.produtoPort.update(product);
	}

	@Override
	public List<Produto> findAll() {
		return this.produtoPort.findAll();
	}

	@Override
	public Produto findById(Long id) {
		return this.produtoPort.findById(id);
	}
		
}
