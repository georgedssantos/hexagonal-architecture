package com.example.application.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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
	
	@NotBlank(message = "O nome é obrigatório")
	@Column(name = "NOME", nullable = false)
    private String nome;
    
	@NotBlank(message = "A descrição é obrigatória")
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	
	//@Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="O preço é obrigatório")
	@PositiveOrZero
	@Column(name = "PRECO", nullable = false)
    private double preco;

}
