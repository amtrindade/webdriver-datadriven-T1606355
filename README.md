# Projeto de Testes Automatizados com Selenium WebDriver

Projeto Java com Maven para automacao de testes Web usando Selenium WebDriver, TestNG e WebDriverManager.

## Tecnologias utilizadas

- Java
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager
- Apache POI (leitura de dados em planilha)

## Pre-requisitos

- Java JDK 11+ instalado
- Maven 3.8+ instalado
- Navegador Google Chrome ou Mozilla Firefox instalado
- Git instalado

## Como clonar o projeto

Use os comandos abaixo, substituindo pela URL real do repositorio:

```bash
git clone <URL-DO-REPOSITORIO>
cd datadriven-webdriver-T1606355
```

## Configuracao do navegador

O projeto le a configuracao em:

- `src/test/resources/webdriver.properties`

Propriedade utilizada:

- `brownser`

Valores aceitos no codigo:

- `firefox`
- `firefox-headless`
- `chrome`
- `chrome-headless`

Exemplo de configuracao:

```properties
brownser chrome
```

## Como executar os testes

### Executar todos os testes

```bash
mvn clean test
```

### Executar uma classe especifica de teste

```bash
mvn -Dtest=SearchCountryTest clean test
```

## Dados de teste

- Dados estaticos no DataProvider da classe de teste
- Dados de planilha em: `src/test/resources/paises.xls`

## Resultados da execucao

Apos a execucao, os principais artefatos ficam em:

- `target/` (inclui screenshots gerados no AfterMethod)
- `target/surefire-reports/`
- `test-output/`

## Estrutura de testes

- Classe base: `src/test/java/com/core/BaseTest.java`
- Fabrica de driver: `src/test/java/com/core/DriverFactory.java`
- Testes: `src/test/java/com/test/SearchCountryTest.java`

## Observacoes

- O projeto abre a pagina da Wikipedia para validar busca por paises.
- Para execucao em CI, prefira os modos headless (`chrome-headless` ou `firefox-headless`).
