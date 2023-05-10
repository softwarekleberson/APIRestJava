# fatec-topicos
This project contains the base source code for the course Topicos Especiais em Informática @ Fatec Mogi das Cruzes

Clean Architecture API Rest para Gerenciamento de Clientes e Produtos
Este repositório contém uma aplicação API Rest para gerenciamento de clientes e produtos, utilizando a arquitetura Clean Architecture. Essa aplicação foi desenvolvida em Java com o framework Spring Boot e visa fornecer um conjunto de recursos para que as operações de gerenciamento de clientes e produtos possam ser realizadas.

Tecnologias Utilizadas
Java 17
Spring Boot
H2
JUnit (para testes unitários)
Mockito (para testes de integração)

Estrutura do Projeto
A estrutura do projeto segue a organização proposta pela Clean Architecture, dividindo a aplicação em camadas independentes e isoladas. As camadas são:

Controllers: responsáveis por lidar com as requisições HTTP e enviar as respostas adequadas.
Use Cases: responsáveis pela lógica de negócio da aplicação, manipulando as entidades e realizando as operações necessárias.
Repositories: responsáveis pela interação com a fonte de dados, no caso, o banco de dados H2.
Entities: responsáveis pela representação das entidades da aplicação.

Como Utilizar
Para utilizar a aplicação, é necessário possuir o Java 17. Depois, basta seguir os seguintes passos:

Clone o repositório:
bash

Copy code
https://github.com/softwarekleberson/APIRestJava

Importe o projeto na sua IDE de preferência.

Crie um arquivo .env na raiz do projeto com as seguintes variáveis de ambiente:

bash
Copy code
PORT=8080

Inicie o servidor através do Spring Boot.
Testes
Para executar os testes unitários e de integração, basta executar o seguinte comando na raiz do projeto:

bash
Copy code
./mvnw test
Os testes unitários testam cada uma das camadas da aplicação separadamente, enquanto os testes de integração verificam o correto funcionamento da aplicação como um todo.

Contribuição
Se você deseja contribuir com este projeto, fique à vontade para abrir uma pull request. Qualquer ajuda é bem-vinda!






