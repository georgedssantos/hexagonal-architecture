package com.example.application.adapters.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.example.application.core.exceptions.DataViolationException;
import com.example.application.core.exceptions.NotFoundException;
import com.example.application.core.model.Produto;
import com.example.application.core.ports.ProdutoRepositoryPort;

@Repository
public class ProdutoRepository implements ProdutoRepositoryPort {

    @Autowired
    private SpringDataProdutoRepository springDataProdutoRepository;

	@Override
    public Produto save(Produto produto) {
    	produto.setId(null);
		return this.springDataProdutoRepository.save(produto);
    }

	@Override
    public void deleteById(Long id) {
		checkExistence(id);	
		try {
			this.springDataProdutoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataViolationException(id);
		}
    }

	@Override
	public Produto update(Produto product) {		
		checkExistence(product.getId());
		return this.springDataProdutoRepository.save(product);
	}

	@Override
	public List<Produto> findAll() {
		return this.springDataProdutoRepository.findAll();
	}

	@Override
	public Produto findById(Long id) {
		Produto product = checkExistence(id);	
		return product;
	}
	
	private Produto checkExistence(Long id) {
		Produto productFound = this.springDataProdutoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(id));
		return productFound;
	}

}
