# Performance testes Blaze

Automação de testes da API/Performance da BlazeDemo, desenvolvida em Java 17, utilizando httpcomponents do apache, Cucumber (BDD), JUnit. 
O projeto inclui relatórios no .csv, e execução dos testes em sincronia, além de execução com o GitHub Actions

---

🚀 Objetivo

Realizar uma emissão de voo na blazeDemo:

✅ Escrita de cenários com Cucumber (BDD)

✅ Testes automatizados para métodos HTTP (GET, POST, PUT, DELETE)

✅ Integração contínua com GitHub Actions


---

## 📊 Relatórios com .csv

ao final da execução é gerado log em uma tabela .csv


---

## 🛠️ Tecnologias Utilizadas
| Tecnologia                  | Finalidade                                       |
|-----------------------------|--------------------------------------------------|
| Java 17                     | Linguagem base                                   |
| Maven                       | Gerenciador de dependências e build automation   |
| Cucumber 6.11.0             | Testes BDD com escrita de cenários em Gherkin    |
| JUnit 4.13.2                | Framework de execução dos testes                 |
| Apache HttpClient 5.2       | Realizar requisições HTTP/HTTPS                  |
| Apache HttpClient Fluent 5.2| API fluente para simplificar chamadas HTTP       |
| Jackson Databind 2.15.2     | Serialização e desserialização JSON              |
| Commons CSV 1.10.0          | Geração e manipulação de arquivos CSV            |
| SLF4J Simple 2.0.9          | Logging simples                                  |

---

## ▶️ Como Executar Localmente

### ✅ Pré-requisitos

- Java 17 instalado  
- Maven 3.8+ instalado  

### ▶️ Comando de execução

```bash
mvn clean test

```

## ⚙️ Integração Contínua

- **GitHub Actions**: Automatização via workflows YAML  


---

