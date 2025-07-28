
# Projeto - Crud de usuarios com Java

Este projeto simula um CRUD de usuários com persistência em memória, baseado nos principais verbos HTTP (POST, GET, PUT, DELETE), imitando o comportamento de uma API REST — mas 100% em Java puro e terminal.

## Objetivo do Projeto
O projeto surgiu a partir de uma curiosidade ao assistir vídeos sobre Spring Boot. Decidi então recriar o funcionamento de uma API CRUD utilizando apenas Java puro, com o objetivo de entender melhor os conceitos por trás das abstrações oferecidas por frameworks
## Funcionalidades

- Criar um novo usuario
- Busca um usuario
- Busca pelo id do usuario
- Atualiza pelo id do usuario
- Deleta pelo id do usuario


## Estrutura utilizada
O projeto foi estruturado na arquitetura de camadas (entities, repository, service, controller,application)

com.pedroramos.crudusuarios
├── application       → Classe Main (interface terminal)
├── controller        → Camada de controle (operações e fluxo)
├── entity            → Modelo de dados (classe Usuario)
├── repository        → Simula a persistência com lista em memória
├── service           → Regras de negócio e validações
└── exceptions        → Exceções personalizadas





## Tecnologias utilizadas

Nesse projeto utilizei:

- Java 21
- Maven 
- Git (utilizei o padrao de commit e o padrao de branchs)
- Biblioteca Jackson
- Listas em Java



## Uso/Exemplos

Na camada application, utilizei JSON para simular a comunicação típica de APIs REST, mesmo executando tudo no terminal. Para isso, usei a biblioteca Jackson, que permite a conversão entre objetos Java e strings JSON, simulando o envio e recebimento de dados como em uma API real.

### Criar Usuario (Simulação do POST)
```
{"nome": "Pedro", "email": "pedro@email.com", "idade": 22}

```
- Ele desserializa a string json (transforma) em objeto Java
- Obs: Não é necessario passar o id na hora de cadastrar, pois a propriedade ID é apenas lida e não escrita pelo JSON, e é autoincrementada no repositorio.

### Buscar Usuario (Simulação do GET)
```
[
  {
    "id": 1,
    "nome": "Pedro",
    "email": "pedro@email.com",
    "idade": 22
  }
]
```
- Exemplo de saida de uma lista de usuarios
- Ele serializa (transforma) o objeto Java em um JSON e exibi no terminal.

### Buscar Usuario pelo Id (Simulação - GET - ID)
```
 {
    "id": 1,
    "nome": "Pedro",
    "email": "pedro@email.com",
    "idade": 22
  }
```
- Ele retorna o usuario achado com base no id passado, podendo lançar uma exceção e uma mensagem se não achar o usuario.

### Atualizar o Usuario pelo ID (Simulação - PUT- ID)

- Ele recebe um id e um novo objeto de Usuario, setando novos valores e modificando o usuario antigo no repository.

### Remover o Usuario pelo ID (Simulação - DELETE - ID)

- Ele recebe um id que irá passar por uma validação de existencia e irá remover aquele usuario do banco em memoria.
## Tratamento de Erros
- Neste projeto eu implementei um tratamento de erros com exceções personalizadas para: 
    
    - Usuario não encontrado
    - Nenhum usuario registrado
    - Dados inválidos no cadastro

- Além de validações de campos obrigatorios (nome, email, idade).
## Aprendizados

- Este projeto foi bem desafiador e necessitou de pensamento lógico e pesquisas em foruns e artigos na internet. Outros aprendizados que foram grandes:
    
    - Uso do git com commits bem estruturas e branch para cada função que fiz
    - Aprendizado sobre verbos http, o que é uma API e o que é JSON
    - Como o Jackson trabalha
    - Tratamento de exceções personalizadas
    - Listas em java
    - Programação orientada a objetos
    - Separação de responsabilidades
    - Validações
    - Arquitetura em camadas



## Autor

- [@pedro-augusto-ramos](https://github.com/pedro-augusto-ramos)


## Proximos passos

- Fazer um projeto com essa estrutura, porém com persistencia em arquivos
- Aprender um banco de dados real
- Replicar esse mesmo crud em um framework

