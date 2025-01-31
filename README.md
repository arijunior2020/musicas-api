# 🎵 API de Gerenciamento de Músicas

Este é um projeto de API para gerenciamento de músicas, desenvolvido em **Java** utilizando **Spring Boot** com arquitetura **multicamadas**. A API permite operações CRUD (Create, Read, Update, Delete) para armazenar e gerenciar músicas em um banco de dados **H2**, persistindo os dados em arquivo local.

## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.2**
- **Spring Web** (Para criação da API REST)
- **Spring Data JPA** (Para integração com o banco de dados)
- **H2 Database** (Banco de dados em memória com persistência em arquivo)
- **Lombok** (Para reduzir o boilerplate de código)
- **Swagger (Springdoc OpenAPI)** (Para documentação automática da API)

---

## 📚 Arquitetura do Projeto

O projeto segue uma **arquitetura em camadas**, garantindo separação de responsabilidades:

```
📂 musicas-api
 └️ src/main/java/com/example/musicas
   ├️ 📂 config        -> (Configuração do Swagger)
   ├️ 📂 controller    -> (Recebe requisições HTTP e delega para o Service)
   ├️ 📂 dto          -> (Objetos de Transferência de Dados, evitando expor a entidade diretamente)
   ├️ 📂 model        -> (Entidades do banco de dados)
   ├️ 📂 repository   -> (Camada de acesso a dados, interface com JPA)
   ├️ 📂 service      -> (Regras de negócio)
   └️ 📝 MusicasApiApplication.java -> (Classe principal do Spring Boot)
```

### 📁 Explicação das Camadas

- **Controller**: Camada que recebe as requisições HTTP e encaminha para o Service.
- **Service**: Contém a lógica de negócio da aplicação.
- **Repository**: Interface com o banco de dados, utiliza **Spring Data JPA**.
- **DTO (Data Transfer Object)**: Objetos para trafegar dados, evitando expor a entidade diretamente.
- **Model**: Representa as entidades do banco de dados (mapeadas com `@Entity`).

---

## 📂 Configuração do Banco de Dados H2
A aplicação utiliza **H2 Database** e persiste os dados localmente.

**Arquivo `application.properties`**:

```properties
spring.application.name=musicas-api

# ConfiguraÃ§Ã£o do banco de dados H2
spring.datasource.url=jdbc:h2:file:./data/musicasdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.platform=h2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# ConfiguraÃ§Ã£o do Hibernate para criar as tabelas automaticamente
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false

```

Para acessar o banco de dados H2:
- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:file:./data/musicasdb`
- **Usuário:** `sa`
- **Senha:** *(deixe em branco)*

---

## 📚 Endpoints da API

### 🎶 **Músicas** (`/musicas`)

| Método | Rota          | Descrição |
|--------|--------------|-----------|
| `GET`  | `/musicas`   | Lista todas as músicas |
| `GET`  | `/musicas/{id}` | Busca uma música pelo ID |
| `POST` | `/musicas`   | Adiciona uma nova música |
| `DELETE` | `/musicas/{id}` | Remove uma música pelo ID |

### 🏠 **HomeController** (`/`)

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET`  | `/`  | Mensagem de status da API |

---

## 📝 Uso dos DTOs

### **DTO de Entrada (`MusicaRequestDTO`)**
Evita que o cliente envie campos como `id`.

```java
@Data
public class MusicaRequestDTO {
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int duracao;
}
```

### **DTO de Saída (`MusicaDTO`)**
Evita expor diretamente a entidade.

```java
@Data
public class MusicaDTO {
    private Long id;
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int duracao;
}
```

---

## 📚 Swagger e Documentação da API

**Acesse a documentação da API em:**
- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🛠️ Como Rodar o Projeto

1. **Clone o repositório**:
```bash
git clone https://github.com/arijunior2020/musicas-api.git
cd musicas-api
```

2. **Compilar e rodar a aplicação**:
```bash
mvn clean install
mvn spring-boot:run
```

3. **Acesse a API:**
- **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **Banco de dados H2:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 💡 Conclusão
Este projeto implementa uma **API RESTful** para gerenciamento de músicas, utilizando **Spring Boot**, **arquitetura multicamadas**, **banco H2 persistente** e **Swagger** para documentação.

💡 **Possíveis melhorias:**
- Implementar autenticação via **Spring Security**
- Criar um frontend com **React** ou **Angular**
- Permitir exportação de músicas em **CSV** ou **JSON**

💡 **Dúvidas ou sugestões?** Fique à vontade para contribuir! 🚀🎵