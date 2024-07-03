package com.example.application.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO", nullable = false)
    private Long id;
	
	@NotBlank
	@Column(name = "NOME", nullable = false)
    private String nome;
    
	@NotBlank
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	
	@NotNull
	@Column(name = "PRECO", nullable = false)
    private double preco;


}
