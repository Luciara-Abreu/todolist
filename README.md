### ToDoList Application - Rocketseat outubro/2023
Bem-vindo à aplicação ToDoList! Esta é uma aplicação simples de lista de tarefas construída usando Java Spring Boot e várias tecnologias modernas. A aplicação permite aos usuários criar, visualizar, atualizar tarefas em uma lista de tarefas.

Tecnologias Utilizadas
Java Spring Boot: O framework Spring Boot é usado para desenvolver aplicativos Java de maneira rápida e fácil, proporcionando um ambiente robusto e eficiente para construção de aplicativos.

Lombok: O projeto Lombok ajuda a reduzir a verbosidade do código Java, automatizando a geração de métodos comuns, como getters, setters e construtores.

JPA (Java Persistence API): JPA é uma especificação Java para mapeamento objeto-relacional, facilitando a interação com bancos de dados relacionais no Java.

Spring Boot DevTools: Esta ferramenta ajuda a melhorar a produtividade durante o desenvolvimento, fornecendo funcionalidades como reinicialização automática da aplicação quando arquivos são alterados.

H2 Database: O H2 é um banco de dados SQL de código aberto muito rápido, que pode ser usado em modo de memória, proporcionando facilidade para testes e desenvolvimento.

Render: A Render é uma plataforma de hospedagem para desenvolvedores, facilitando o processo de implantação e hospedagem de aplicativos.

Como Executar a Aplicação
Certifique-se de ter o Java instalado em sua máquina.

Clone o Repositório:

sh
Copy code
git clone https://github.com/seu-usuario/todo-list-app.git
cd todo-list-app
Configure o Banco de Dados H2:

Verifique as configurações do banco de dados H2 em application.properties para garantir que estejam corretas.
Execute a Aplicação:

sh
Copy code
./mvnw spring-boot:run
Acesse a Aplicação:

A aplicação estará disponível em http://localhost:8080.
Endpoints da API
A aplicação oferece os seguintes endpoints da API:

GET /api/tasks: Retorna todas as tarefas.
GET /api/tasks/{id}: Retorna uma tarefa específica por ID.
POST /api/tasks: Cria uma nova tarefa.
PUT /api/tasks/{id}: Atualiza uma tarefa existente por ID.
Esse end point está em contrução --> DELETE /api/tasks/{id}: Exclui uma tarefa existente por ID.
