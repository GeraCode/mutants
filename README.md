# mutants
mutants
# Project :: Mutants

This microservice is in charge of the following:
1. Verify Mutant By DNA
2. Stats of Persons in the Document MongoDB(persons)

### POST  endPoint
there is an example about mutant service
http://localhost:8081/mutant/?dnaArray=AATTCC&dnaArray=AATTCC&dnaArray=GCATCC&dnaArray=GGGAAC&dnaArray=GGGATA&dnaArray=GGGGAC

### GET  endPoint
there is an example about stats service
http://localhost:8081/stats

##localhost and name of project 

spring.application.name=mutant-service
server.port=8081

## host, port and database of mongoDB
spring.data.mongodb.host=127.0.0.1
spring.data.mongodb.port=27017
spring.data.mongodb.database=test
