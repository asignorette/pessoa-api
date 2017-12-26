## Pessoa-API 

###Tecnologias a serem utulizadas:
* Spring Boot (json/restful) 
* Srping data;
* Mavem;
* MongoDB no lugar do Postgres;
* Docker (para disponibilizar o banco de dados);
* JUnit;
* Postman;

(Spring Boot + MongoDB)
- Crud de pessoas

Endpoints:
- Salvar uma pessoa (POST): /pessoas/
```
{
    "nome": "Adriano Ribeiro",
    "cpf": "00000000001",
    "dtNascimento": "1982-07-10",
    "endereco": {
    	"logradouro":"Rua A, 100",
    	"bairro":"Floradas de Sao José",
    	"cidade":"Sao Jose dos Campos",
    	"uf":"SP",
    	"cep":"12230087"
    }
}
```

- Buscar todas as pessoa (GET): /pessoas/ 
- Buscar uma pessoa (GET): /pessoas/:id
- Remover uma pessoa (Delete): /pessoas/:id

###Sugestão para rodar o MongoDB no docker (no meu caso estava usando Windows). 

1. docker run --name <nome-de-seu-container> -p 27017:27017 -d mongo
1. docker exec -it <nome-de-seu-container> mongo local
1. Feito isso abra o arquivo applications.properties

#MongoDB
spring.data.mongodb.host=<host>
spring.data.mongodb.port=<porta>
spring.data.mongodb.database=<database>

Seguindo os passo acima ao inicializar a aplicação sua aplicação você terá acesso ao banco de dados.