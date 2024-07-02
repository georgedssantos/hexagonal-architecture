package com.example.application.core.ports;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.application.adapters.persistence.ProdutoRepository;
import com.example.application.core.model.Produto;
import com.example.application.exceptions.DataViolationException;
import com.example.application.exceptions.NotFoundException;

@Service
public class ProdutoRepositoryPortImpl implements ProdutoRepositoryPort {
    
    @Autowired
    private ProdutoRepository produtoRepository;

	@Override
    public Produto save(Produto produto) {
    	produto.setId(null);
		return this.produtoRepository.save(produto);
    }

	@Override
    public void deleteById(Long id) {
		checkExistence(id);	
		try {
			this.produtoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataViolationException(id);
		}
    }

	@Override
	public Produto update(Produto product) {		
		checkExistence(product.getId());
		return this.produtoRepository.save(product);
	}

	@Override
	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto findById(Long id) {
		Produto product = checkExistence(id);	
		return product;
	}
	
	private Produto checkExistence(Long id) {
		Produto productFound = this.produtoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(id));
		return productFound;
	}


}
