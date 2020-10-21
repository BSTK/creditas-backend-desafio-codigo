## Resolução do Desafio de Código - Backend Creditas

https://github.com/Creditas/challenge/blob/master/backend/code-challenge/README.md

Aplicação desenvolvida com Spring Boot

Executar projeto
```
./mvnw spring-boot:run
```

[POST] 
```
http://localhost:9090/api/v1/emprestimos/ofertar-proposta
```

[PLAYLOAD]
```json
{
    "nome": "Bruno",
    "cpf": "123.456.789-10",
    "idade": 30,
    "localizacao": "SP",
    "salario": 2900
}
```
