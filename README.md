# hexagonal-architecture
📚 ☕️ Simple Java Application With Hexagonal Architecture

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
- Implementam os ports definidos no core. ProdutoRepository é uma implementação de ProdutoRepositoryPort que utiliza um HashMap para simular um repositório em memória. ProdutoController é um controlador REST que injeta ProdutoService para lidar com operações HTTP. </br>
- Persistence: Implementa a interface ProdutoRepositoryPort para persistência em banco de dados. </br>
- Web: Implementa a interface de ProdutoController para expor endpoints HTTP. </br>


```python
src/
├── adapters/
│   ├── persistence/
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
└── HexagonalarchitectureApplication.java
```
