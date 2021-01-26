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

#Instruçoes
Ao fazer um cadastro, siga as instruçoes na documentacao, informe apenas que esta descrito
na documentaçao.

# Tecnologias

Quarkus, framework do Java.
Banco de Dados h2, JPA, Hibernate Validator, documentação Swagger.
