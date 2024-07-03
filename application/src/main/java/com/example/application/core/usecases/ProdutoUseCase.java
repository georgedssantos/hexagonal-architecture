package com.example.application.core.usecases;

import java.util.List;

import com.example.application.core.model.Produto;

public interface ProdutoUseCase {
	
    Produto save(Produto produto);
    
    void deleteById(Long id);
    
    Produto update(Produto product);
    
    List<Produto> findAll();
    
    Produto findById(Long id);

}
