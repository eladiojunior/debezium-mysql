# Projeto Debezium com Kafka

Exemplo de projeto para estudar sobre a solução Debezium.

## O que é o Debezium?

Uma plataforma distribuída que transforma seus bancos de dados existentes em fluxos de eventos, para que os aplicativos possam reagir rapidamente a cada alteração no nível de linha nos bancos de dados. Foi construído sobre o Kafka e fornece conectores compatíveis com o Kafka Connect. O Debezium registra o hitórico de alterações de bancos de dados nos logs Kafka.
Utilizaremos para exemplo o banco de dados MySQL como fonte de informações que o Debezium fica escutando os scripts de INSERT, UPDATE e DELETE e colocando-os na fila de mensageria, utilizaremos o Kafka. Em seguida criaremos um serviço que irá retirar da fila de mensageria de colocar em um banco de dados MongoDB.

## Criei um projeto utilizando o framework Quarkus:

- **debezium-mysql**: com um docker-compose para subir os containers necessários para exemplo:
    - **quarkus-cadastro-mysql** = uma aplicação (API), em Quarkus, de CRUD para manipular o banco de dados MySQL (DB_CADASTRO) para verificar como o Debezium irá colocar as operações na fila de mensageria (Kafka);
    - **quarkus-cadastro-mongodb** = uma aplicação (API), em Quarkus, com um leitor da fila e gravação no banco MongoDB, com uma operação de consulta apenas; 

Para rodar precisa subir os container, definidos no docker-compose.

Crie a estrutura de banco de dados: DB_CADASTRO, definido no arquivo:
```
quarkus-cadastro-mysql> db\migration\V0.0.1__Criar_DB_Cliente.sql
```

Registrar o connector, definido no arquivo: registra-connector-mysql-debezium
```
/> config-debezium.cmd
```

Utilize o projeto (quarkus-cadastro-mysql) para registrar os clientes e visualiza-los no Kafka. 
```
./mvn quarkus:dev
```
Acesse o link do projeto: http://localhost:8081/swagger-ui/

Para visualizar os registro no Kafka, utilizamos o KAFDROP: http://localhost:9000/

Pronto!