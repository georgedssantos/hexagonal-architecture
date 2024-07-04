package com.example.application.adapters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.core.model.Produto;

@Repository
public interface SpringDataProdutoRepository extends JpaRepository<Produto, Long> {
	
}
