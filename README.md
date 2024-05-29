# Informações de contato:

- [<img src="https://img.icons8.com/color/48/000000/linkedin.png" width="24"/>](https://www.linkedin.com/in/jjhon/) **Linkedin:** [Perfil Linkedin](https://www.linkedin.com/in/jjhon/)
  
- [<img src="https://img.icons8.com/color/48/000000/portfolio.png" width="24"/>](https://jhonjhon95.github.io/portfolio-site/) **Portfólio:** [Portfólio Online](https://jhonjhon95.github.io/portfolio-site/)
  
- [<img src="https://img.icons8.com/color/48/000000/whatsapp--v2.png" width="24"/>](https://api.whatsapp.com/send?phone=5566997218952) **WhatsApp:** [Conversar no WhatsApp](https://api.whatsapp.com/send?phone=5566997218952)
  
- [<img src="https://img.icons8.com/ios-glyphs/30/000000/github.png" width="24"/>](https://github.com/jhonjhon95) **GitHub:** [Perfil GitHub](https://github.com/jhonjhon95)




# Desafio DB: Testando API

Projeto para garantir cobertura de testes de usabilidade para a aplicação BugBank

##  Requisitos para execução
* Java 11+ JDK instalado
* Maven configurado no PATH da aplicação
* IDE: intellij idea ou VSCode

## Estrutura do projeto

````text
Test-DBTestWEB
├── src
│   ├── main
│   │   └── java
│   │       ├── browser
│   │       ├── data
│   │       ├── dataFactory
│   │       └── reports
│   │       └── utils
│   └── test
│       └── java
│           ├── pageElements
│           ├── pageTask
│           ├── suiteTest
│           └── validations
├── .gitignore
└── pom.xml
└── README.md

````

## Como executar os testes
Execução através da IDE: É possível selecionar o teste desejado e simplesmente clicar em 'play' no método correspondente
do teste ou pode-se executar pela linha de comando usando o seguinte comando:<br>

Instalar dependências<br>
```bash
mvn clean install 
```
Rodar todos os testes<br>
```bash
mvn test 
```
Rodar Tags
```bash
mvn test -Dgroups="REGRESSAO"
```
Após a execução dos testes será criada na raiz do projeto a pasta "reports"

# Plano de Teste e Estratégia de Testes.

## Introdução

- Este plano descreve a estratégia de testes para a API de Consultas de Ceps válidos e inválidos, visando garantir a cobertura de testes, identificar e corrigir bugs, e assegurar que a aplicação atende aos requisitos.

  ## Objetivos do Teste

- Validar o funcionamento correto da aplicação.
- Garantir robustez e confiabilidade.
- Identificar e corrigir bugs.
- Assegurar conformidade com a documentação técnica e UI/UX.
- Verificar usabilidade e qualidade do código.

  ## Escopo do Teste

- Funcionalidades a Testar: Transferência entre contas da aplicação BugBank.

  ## Abordagem de Teste

- Testes de Usabilidade: Validar funcionalidades conforme os requisitos.

- Testes de Regressão: Assegurar que novas alterações não impactem funcionalidades existentes.