# hexagonal-architecture

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
└── Application.java
