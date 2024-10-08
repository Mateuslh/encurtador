
# Encurtador de URLs - API

Este projeto é uma aplicação de encurtamento de URLs desenvolvida com **Spring Boot**. A aplicação fornece endpoints para encurtar URLs, exibir estatísticas e informações sobre o projeto.

## Endpoints da API

### 1. Encurtar URL
**Endpoint**: `/api/encurtar`  
**Método**: `POST`  
**Descrição**: Encurta uma URL fornecida pelo usuário.

#### Requisição

- **Corpo da requisição**: JSON no seguinte formato:

```json
{
  "url": "https://google.com"
}
```

| Campo | Tipo   | Obrigatório | Descrição                   |
|-------|--------|-------------|-----------------------------|
| `url` | String | Sim         | A URL original a ser encurtada |

#### Resposta de Sucesso

- **Status**: `200 OK`
- **Corpo da resposta**: JSON com a URL encurtada no seguinte formato:

```json
{
  "urlEncurtada": "http://encurtador.dev/abc123"
}
```

| Campo         | Tipo   | Descrição                           |
|---------------|--------|-------------------------------------|
| `urlEncurtada`| String | A nova URL encurtada gerada pelo sistema |

#### Possíveis Erros

- **400 Bad Request**: Se a URL fornecida for inválida ou mal formatada.

```json
{
  "timestamp": "2024-10-08T18:31:03.096+00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Erro ao acessar API de encurtamento. Verifique a requisição.",
  "path": "/api/encurtar"
}
```

- **500 Internal Server Error**: Se ocorrer um erro inesperado no servidor.

```json
{
  "timestamp": "2024-10-08T18:31:03.096+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Erro inesperado ao acessar a API de encurtamento.",
  "path": "/api/encurtar"
}
```

---

### 2. Estatísticas
**Endpoint**: `/api/estatisticas`  
**Método**: `GET`  
**Descrição**: Retorna estatísticas sobre o número total de URLs encurtadas e o tempo médio de resposta do sistema.

#### Resposta de Sucesso

- **Status**: `200 OK`
- **Corpo da resposta**: JSON com as estatísticas do sistema:

```json
{
  "quantidadeUrlsEncurtadas": 100,
  "tempoMedioRespostaMs": 150
}
```

| Campo                        | Tipo   | Descrição                                   |
|------------------------------|--------|---------------------------------------------|
| `quantidadeUrlsEncurtadas`    | int    | O número total de URLs encurtadas           |
| `tempoMedioRespostaMs`        | long   | O tempo médio de resposta em milissegundos  |

#### Possíveis Erros

- **500 Internal Server Error**: Se ocorrer um erro inesperado no servidor ao processar as estatísticas.

```json
{
  "timestamp": "2024-10-08T18:31:03.096+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Erro ao acessar as estatísticas.",
  "path": "/api/estatisticas"
}
```

---

### 3. Sobre
**Endpoint**: `/api/sobre`  
**Método**: `GET`  
**Descrição**: Exibe informações sobre o estudante e o projeto.

#### Resposta de Sucesso

- **Status**: `200 OK`
- **Corpo da resposta**: JSON com informações sobre o estudante e o projeto:

```json
{
  "estudante": "Seu Nome",
  "projeto": "Encurtador de Links"
}
```

| Campo       | Tipo   | Descrição                           |
|-------------|--------|-------------------------------------|
| `estudante` | String | Nome do desenvolvedor do projeto    |
| `projeto`   | String | Nome do projeto desenvolvido        |

#### Possíveis Erros

- **500 Internal Server Error**: Se ocorrer um erro inesperado no servidor.

```json
{
  "timestamp": "2024-10-08T18:31:03.096+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Erro ao acessar informações sobre o projeto.",
  "path": "/api/sobre"
}
```

---

## Rodando o Projeto Localmente

### Requisitos

- **Java 17**
- **Maven**
- **Docker** (opcional, para rodar via container)

### Instruções

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/encurtador.git
   ```

2. Compile o projeto:
   ```bash
   mvn clean package
   ```

3. Execute o projeto:
   ```bash
   java -jar target/encurtador-1.0.0.jar
   ```

4. A aplicação estará disponível em `http://localhost:8080`.

### Usando Docker

Para rodar a aplicação dentro de um container Docker:

1. Construa a imagem Docker:
   ```bash
   docker build -t encurtador-app .
   ```

2. Execute o container:
   ```bash
   docker run -d -p 8080:8080 encurtador-app
   ```

---

## Tecnologias Usadas

- **Spring Boot**: Framework para desenvolvimento Java
- **Maven**: Gerenciador de dependências e build
- **Docker**: Para empacotamento e execução em containers

## Autor

- **Mateus Leal Hemkemeier**
