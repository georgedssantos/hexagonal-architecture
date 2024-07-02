package com.example.application.core.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.core.model.Produto;
import com.example.application.core.ports.ProdutoRepositoryPort;

@Service
public class ProdutoService {
	
	@Autowired
    private ProdutoRepositoryPort produtoRepository;

    public Produto findProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<Produto> findAllProdutos() {
        return produtoRepository.findAll();
    }

    public void saveProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public void deleteProdutoById(Long id) {
        produtoRepository.deleteById(id);
    }
}
