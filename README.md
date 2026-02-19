# Desafio tecnico banco ITAU 🟠

> Um teste técnico pedido em vaga real do Itaú.

---

## 📋 Descrição

Aplicação **Spring Boot** que gerencia transações financeiras e fornece estatísticas sobre elas.

A aplicação permite:

- Adicionar transações
- Consultar estatísticas
- Deletar todas as transações

---

## 🔧 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 17 ou superior**
- **Maven 3.6+** ou usar o Maven Wrapper incluído no projeto (`mvnw` ou `mvnw.cmd`)
- Git (opcional, para clonar o repositório)

### ✔ Verificando as instalações

```bash
java -version
mvn -version
```

---

## 🏗️ Como Buildar

### 🔹 Usando Maven Wrapper (Recomendado)

O projeto inclui um Maven Wrapper, então você não precisa ter o Maven instalado globalmente.

#### Linux/macOS

```bash
./mvnw clean install
```

#### Windows

```bash
mvnw.cmd clean install
```

---

### 🔹 Usando Maven instalado globalmente

```bash
mvn clean install
```

Esse comando irá:

- Limpar o diretório `target/`
- Compilar o código fonte
- Executar os testes
- Gerar o arquivo JAR em:

```
target/Desafio tecnico banco ITAU-0.0.1-SNAPSHOT.jar
```

---

### ⚡ Build sem executar testes

```bash
./mvnw clean install -DskipTests
```

---

## 🚀 Como Rodar

### 🔹 Opção 1: Usando Maven (Recomendado para desenvolvimento)

#### Linux/macOS

```bash
./mvnw spring-boot:run
```

#### Windows

```bash
mvnw.cmd spring-boot:run
```

---

### 🔹 Opção 2: Usando o JAR gerado

Após fazer o build:

```bash
java -jar target/Desafio tecnico banco ITAU-0.0.1-SNAPSHOT.jar
```

---

### 🔹 Opção 3: Executando a classe principal

```bash
./mvnw exec:java -Dexec.mainClass="dev.desafiotecnicobancoitau.DesafioTecnicoBancoITAUApplication"
```

---

## 🌐 Verificando se a aplicação está rodando

URL Base:

```
http://localhost:8080
```

Teste inicial:

```
http://localhost:8080/estatistica
```

---

## 🧪 Como Testar

### 🔹 Executando todos os testes

#### Linux/macOS

```bash
./mvnw test
```

#### Windows

```bash
mvnw.cmd test
```

#### Com Maven instalado

```bash
mvn test
```

---

### 🔹 Executando um teste específico

```bash
./mvnw test -Dtest=DesafioTecnicoBancoITAUTests
```

---

### 🔹 Visualizando relatórios de teste

Após executar os testes, os relatórios estarão disponíveis em:

```
target/surefire-reports/
```

---

## 📡 Endpoints da API

### 🔹 Transações

#### ➕ POST /transacao

Adiciona uma nova transação.

```bash
curl -X POST http://localhost:8080/transacao \
  -H "Content-Type: application/json" \
  -d '{
    "valor": 100.50,
    "dataHora": "2024-01-15T10:30:00Z"
  }'
```

**Respostas:**

- `201 Created` - Transação criada com sucesso
- `422 Unprocessable Entity` - Erro de validação
- `400 Bad Request` - Erro na requisição

---

#### 🗑️ DELETE /transacao

Deleta todas as transações armazenadas.

```bash
curl -X DELETE http://localhost:8080/transacao
```

Resposta:

```
200 OK - Transações deletadas com sucesso
```

---

### 📊 Estatísticas

#### 🔎 GET /estatistica

Retorna estatísticas das transações dos últimos **60 segundos** (configurável em `application.yml`).

```bash
curl http://localhost:8080/estatistica
```

Exemplo de resposta:

```json
{
  "soma": 100.50,
  "min": 100.50,
  "max": 100.50,
  "media": 100.50,
  "quantidade": 1
}
```

---

## ⚙️ Configuração

As configurações da aplicação estão em:

```
src/main/resources/application.yml
```

```yaml
estatistica:
  segundos: 60
```

Esse valor define quantos segundos no passado serão considerados para o cálculo das estatísticas.

---

## 🛠️ Tecnologias Utilizadas

- Spring Boot 4.0.1
- Java 17
- Maven
- Lombok
- JUnit 5

---

## 📁 Estrutura do Projeto

```
Desafio tecnico banco ITAU/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev/desafiotecnicobancoitau/
│   │   │       ├── Estatisticas/
│   │   │       ├── Transacoes/
│   │   │       └── DesafioTecnicoBancoITAUApplication.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

---

## 🐛 Solução de Problemas

### ❌ Erro: "Java version not found"

Certifique-se de ter o Java 17 instalado e configurado no PATH.

---

### ❌ Erro: "Port 8080 already in use"

Altere a porta no `application.yml`:

```yaml
server:
  port: 8081
```

---

### ❌ Erro ao executar ./mvnw

```bash
chmod +x mvnw
```

---

## 📝 Notas

- A aplicação armazena transações em memória.
- As estatísticas consideram apenas transações dos últimos N segundos.
- Ao reiniciar a aplicação, todas as transações são perdidas.

---

## 📄 Licença

Este projeto é um teste técnico.
