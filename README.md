# hexagonal-architecture
📚 ☕️ Simples API REST no padrão de arquitetura hexagonal


Um padrão de arquitetura de software que promove a separação das responsabilidades, permitindo que a lógica de negócios seja independente de detalhes de implementação como persistência ou interface do usuário.

## Descrição dos Componentes

1. ** Núcleo da Aplicação (Core): </br>
- Contém a lógica de negócios da aplicação. </br>
2. ** Model: </br>
- Define a estrutura de dados do Produto. </br>
3. ** Portas (Ports):</br>
- Define as interfaces que serão implementadas por adaptadores. </br>
- Use Cases: Contém os serviços que operam sobre os modelos de dados. </br>
3. ** Adaptadores (Adapters): </br>
- Implementam os ports definidos no core. ProdutoRepository é uma implementação de ProdutoRepositoryPort. ProdutoController é um controlador REST que injeta ProdutoUseCase para lidar com operações HTTP. </br>
- Persistence: Implementa a interface ProdutoRepositoryPort para persistência em banco de dados. </br>
- Web: Implementa a interface de ProdutoController para expor endpoints HTTP. </br>


```python
src/
├── adapters/
│   ├── persistence/
│   │   └── SpringDataProdutoRepository.java
│   │   └── ProdutoRepository.java
│   └── web/
│       └── ProdutoController.java
├── core/
│   ├── model/
│   │   └── Produto.java
│   ├── ports/
│   │   └── ProdutoRepositoryPort.java
│   └── usecases/
│       └── ProdutoService.java
│       └── ProdutoUseCase.java
└── Application.java
```

### Vantagens da Arquitetura Hexagonal:

- **Separação de Preocupações**: Clarifica e separa as responsabilidades entre a lógica de negócios e os detalhes técnicos.
  
- **Testabilidade**: Facilita a escrita de testes unitários e de integração, pois a lógica de negócios não depende diretamente de infraestrutura externa.

- **Flexibilidade e Manutenibilidade**: Permite trocar ou atualizar os adaptadores sem impactar a lógica de negócios, desde que os contratos (portas) sejam mantidos.

- **Reutilização de Código**: Os adaptadores podem ser reutilizados em diferentes contextos ou projetos, desde que respeitem os contratos definidos pelas portas.


![alt tag](https://github.com/georgedssantos/hexagonal-architecture/blob/main/documentacao/tela-1.PNG)
![alt tag](https://github.com/georgedssantos/hexagonal-architecture/blob/main/documentacao/tela-2.PNG)

### Configuração
* Java 21
* Spring Boot 3.3.1
* Gradle
* H2 Data Base - JDBC URL: jdbc:h2:mem:testdb - http://localhost:8080/h2-console
* Springdoc-openapi - Swagger-ui - http://localhost:8080/swagger-ui/index.html

