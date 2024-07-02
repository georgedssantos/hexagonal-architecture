# hexagonal-architecture

Um padrão de arquitetura de software que promove a separação das responsabilidades, permitindo que a lógica de negócios seja independente de detalhes de implementação como persistência ou interface do usuário.

## Usage
Descrição dos Componentes </br>
Núcleo da Aplicação (Core): Contém a lógica de negócios da aplicação. </br>
Model: Define a estrutura de dados do Produto. </br>
Portas (Ports): Define as interfaces que serão implementadas por adaptadores. </br>
Use Cases: Contém os serviços que operam sobre os modelos de dados. </br>
Adaptadores (Adapters): </br>
Implementam os ports definidos no core. ProdutoRepository é uma implementação de ProdutoRepositoryPort que utiliza um HashMap para simular um repositório em memória. ProdutoController é um controlador REST que injeta ProdutoService para lidar com operações HTTP.
Persistence: Implementa a interface ProdutoRepositoryPort para persistência em banco de dados. </br>
Web: Implementa a interface de ProdutoController para expor endpoints HTTP.


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
