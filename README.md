# Como rodar?

. Acesse o diretorio "escola-api" e rode o comando  mvnw compile quarkus:dev (para executar

o projeto localmente). A api ficara disponivel em http://localhost:8080/api

e utilize o swagger para ver todos os endpoints em http://localhost:8080/q/swagger-ui/#/ .

. Para os testes, no diretorio "escola-api" rode o comando mvnw verify .

Assim, na pasta "escola-api/target" se encontrara uma outra pasta chamada surefire-reports que

se aberta em um navegador mostra um relatorio de testes. 

# O projeto escola-api. Uma API REST.

Uma escola aplica provas de multipla escolha para os alunos. 

A nota do aluno na prova e determinada pela media ponderada das questoes 

com os pesos de cada questao e a nota final e a media aritmetica das notas de todas as provas.

API HTTP que:
- Cadastra o gabarito de cada prova;
- Cadastra as respostas de cada aluno para cada prova;
- Verifica a nota final de cada aluno;
- Lista os alunos aprovados;
Regras de negocio:
- A nota total da prova e sempre maior que 0 e menor que 10.
- A quantidade maxima de alunos e 100.
- O peso de cada questao e sempre um inteiro maior que 0.
- Os alunos aprovados tem media de notas maior do que 7.
- A entrada e saida de dados devera ser em JSON.

# Instrucoes

Temos 3 entidades: aluno, prova e resposta (a resposta de um determinado aluno 
para uma determinada prova). Portanto, para se cadastrar uma resposta
e preciso ter os ids do aluno, que no nosso caso e a matricula, e o id da prova, ou seja, 
cadastrar o aluno e a prova previamente.

Em escola-api\src\main\resources esta o file de configuracao do projeto 
application.properties. Para que o banco de dados nao seja "dropado" a cada vez
que a aplicacao compilar, comente (com #) a 10a linha: 

"quarkus.hibernate-orm.database.generation=drop-and-create"

e descomente 11a, linha que permite atualizacoes: 

"quarkus.hibernate-orm.database.generation=update" .

# Tecnologias

Quarkus, framework do Java.
Banco de Dados h2, JPA, Hibernate Validator, documentação Swagger.
