
# 📌 URL Shortener API (Spring Boot + MongoDB)

Este é um projeto de uma API REST para encurtamento de URLs, desenvolvido com **Spring Boot** e **MongoDB**.

## ✅ Funcionalidades principais:

- Criar uma URL encurtada
- Buscar a URL original através da shortUrl
- Listar todas as URLs cadastradas
- Deletar URLs por longUrl ou por shortUrl

## ✅ Endpoints disponíveis:

### 🔗 Criar uma URL encurtada:

- **POST** `/create-url{longUrl}`  
**Parâmetro:**  
`longUrl` → URL original que será encurtada.

**Exemplo de requisição:**
```
POST http://localhost:8080/create-url?longUrl=https://exemplo.com
```

**Resposta:**  
Retorna a shortUrl gerada.

### 🔍 Buscar URL original a partir da shortUrl:

- **GET** `/get-url{shortUrl}`  
**Parâmetro:**  
`shortUrl` → Código da URL encurtada.

**Exemplo de requisição:**
```
GET http://localhost:8080/get-url?shortUrl=abc123
```

**Resposta:**  
Retorna a longUrl original.

### 📄 Listar todas as URLs salvas:

- **GET** `/`  

**Resposta:**  
Retorna todas as URLs salvas no formato:

```
Long URL: https://exemplo.com, Short URL: abc123
```

### 🗑️ Deletar por longUrl:

- **DELETE** `/delete-by-longurl{longUrl}`  
**Parâmetro:**  
`longUrl` → URL original que você quer deletar.

**Exemplo:**
```
DELETE http://localhost:8080/delete-by-longurl?longUrl=https://exemplo.com
```

### 🗑️ Deletar por shortUrl:

- **DELETE** `/delete-by-shorturl{shortUrl}`  
**Parâmetro:**  
`shortUrl` → Código da URL encurtada.

**Exemplo:**
```
DELETE http://localhost:8080/delete-by-shorturl?shortUrl=abc123
```

## ✅ Tecnologias utilizadas:

- **Java 17**
- **Spring Boot**
- **Spring Data MongoDB**
- **MongoDB Atlas (ou local)**

## ✅ Como rodar o projeto:

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Configure o `application.properties` com sua conexão MongoDB.

3. Rode a aplicação:

```bash
./mvnw spring-boot:run
```
Ou rode pela sua IDE (Eclipse, IntelliJ, VS Code).