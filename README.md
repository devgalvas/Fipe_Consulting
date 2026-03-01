# 🚗 Consulta Tabela Fipe - Java Spring Boot

Um sistema de linha de comando (CLI) desenvolvido em Java com Spring Boot para consultar os valores de veículos atualizados na Tabela Fipe. O projeto consome a [API pública da Fipe (v2)](https://fipe.online/docs/api/fipe) para entregar a precificação de carros, motos e caminhões.

## 🎯 Funcionalidades

- Consulta de marcas disponíveis filtradas por tipo de veículo (Carros, Motos ou Caminhões).
- Listagem de modelos específicos de uma marca escolhida.
- Exibição dos anos de fabricação disponíveis para o modelo.
- Retorno da avaliação completa do veículo, incluindo preço atualizado, tipo de combustível e código Fipe.

## 🛠️ Tecnologias Utilizadas

- **Java 21:** Utilização das features mais recentes da linguagem, como `Records` e `Switch Expressions`.
- **Spring Boot 4.0:** Framework base da aplicação (linha de comando utilizando `CommandLineRunner`).
- **Jackson (com.fasterxml.jackson):** Para desserialização eficiente do JSON retornado pela API para objetos Java.
- **Java HttpClient:** Realização das requisições HTTP (GET) nativas do Java.

## 🚀 Como Executar o Projeto

**Pré-requisitos:**
- Java 21 ou superior instalado.
- Maven instalado (ou utilizar o wrapper `./mvnw` incluso no projeto).

1. Clone o repositório:
```bash
git clone [https://github.com/devgalvas/Fipe_Consulting.git](https://github.com/devgalvas/Fipe_Consulting.git)
```
2. Entre na pasta do projeto:
```bash
cd tabelafipe
```
3. Execute a aplicação via maven:
```bash
./mvnw spring-boot:run
```

## 🧠 Aprendizados e Desafios
Durante o desenvolvimento deste projeto, foram aplicados conceitos fundamentais de desenvolvimento Back-End, incluindo:

- Estruturação de pacotes e responsabilidades (Service, Model, Principal).

- Mapeamento de Arrays e Objetos JSON aninhados para DTOs (Data Transfer Objects).

- Resolução de conflitos de dependências (ajuste de versões do Jackson no pom.xml).

- Tratamento de fluxo de entrada de dados via Scanner no console.


