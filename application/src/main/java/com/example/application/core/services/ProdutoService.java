package com.example.application.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.core.model.Produto;
import com.example.application.core.ports.ProdutoRepositoryPort;
import com.example.application.core.usecases.ProdutoUseCase;

@Service
public class ProdutoService implements ProdutoUseCase {
	
	@Autowired
	private ProdutoRepositoryPort produtoRepositoryPort;

	@Override
    public Produto save(Produto produto) {
		return this.produtoRepositoryPort.save(produto);
    }

	@Override
    public void deleteById(Long id) {
		this.produtoRepositoryPort.deleteById(id);
    }

	@Override
	public Produto update(Produto product) {		
		return this.produtoRepositoryPort.update(product);
	}

	@Override
	public List<Produto> findAll() {
		return this.produtoRepositoryPort.findAll();
	}

	@Override
	public Produto findById(Long id) {
		return this.produtoRepositoryPort.findById(id);
	}
		
}
