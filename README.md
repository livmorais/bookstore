<h1 align="center">Bookstore Project</h1>

This project is a RESTful API for a bookstore, developed using Spring Boot. The aim is to provide CRUD (Create, Read, Update, Delete) operations for books.

### Technologies used

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL 
- Maven

### Running the project

1. Make sure you have Java 17 installed.
2. Configure a MySQL database and update the connection settings in `src/main/resources/application.properties`.
3. Run the command `mvn spring-boot:run` to start the development server.
4. Access the API at `http://localhost:8080/book`.

### Authentication and Authorization

This project uses Spring Security to protect the API with basic authentication. The default credentials are:

- Username: admin
- Password: 1234

### API Endpoints

The API provides the following main endpoints:

- `GET /book`: Returns all available books.
- `GET /book/{id}`: Returns the details of a specific book.
- `POST /book`: Creates a new book.
- `PUT /book/{id}`: Updates the information of an existing book.
- `DELETE book/{id}`: Removes a book from the system.


<h1 align="center">Projeto Livraria</h1>

Este projeto é uma API RESTful para uma livraria, desenvolvida usando o Spring Boot. O objetivo é fornecer operações CRUD (Criar, Ler, Atualizar, Excluir) para livros.

### Tecnologias Usadas

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL 
- Maven

### Executando o Projeto

1. Certifique-se de ter o Java 17 instalado.
2. Configure um banco de dados MySQL e atualize as configurações de conexão em `src/main/resources/application.properties`.
3. Execute o comando `mvn spring-boot:run` para iniciar o servidor de desenvolvimento.
4. Acesse a API em `http://localhost:8080/book`.

### Autenticação e Autorização

Este projeto usa o Spring Security para proteger a API com autenticação básica. As credenciais padrão são:

- Nome de usuário: admin
- Senha: 1234

### Endpoints da API

A API fornece os seguintes endpoints:

- `GET /book`: Retorna todos os livros disponíveis.
- `GET /book/{id}`: Retorna os detalhes de um livro específico.
- `POST /book`: Cria um novo livro.
- `PUT /book/{id}`: Atualiza as informações de um livro existente.
- `DELETE book/{id}`: Remove um livro do sistema.

