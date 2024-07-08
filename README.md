# Spring REST App
REST API in Spring to perform CRUD operations on a H2 in-memory database of Products.
## REST Endpoints
- `/health`
- `/createProduct`
- `/getAllProducts`
- `/getProductById/{id}`
- `/updateProductById/{id}`
- `/deleteProduct/{id}`
## Requirements
### Controller
- Implement the REST endpoints described in the section below
- Create a “Product” DTO to be used by the REST API
- Implement Swagger for the API
- Implement appropriate validation on the endpoints. e.g. Returning a 400 Bad Request responses fields are missing when creating a product
### Service Layer
- Implement a service layer which should act as the intermediary between the Controller and Repository layers of the application
- Should map “Product” DTO to and from “Product” entity/model (Java object used by the repository layer)
### Repository Layer
- Create an in-memory H2 database for the system to store products
- Create a repository layer using Spring JPA
- Create a “Product” entity for the repository layer
- The “Product” entity should have a unique id field that is managed by Spring JPA using sequence generation
## Useful Links
- https://spring.io/guides/tutorials/rest
- https://www.baeldung.com/intro-to-project-lombok
- https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
- https://www.baeldung.com/spring-boot-h2-database
- https://spring.io/projects/spring-data-jpa
- https://www.baeldung.com/java-entity-vs-dto
- https://www.baeldung.com/spring-boot-logback-log4j2
- https://www.baeldung.com/exception-handling-for-rest-with-spring
- https://spring.io/guides/gs/testing-web
- https://www.oracle.com/ie/technical-resources/articles/java/javadoc-tool.html
- https://www.baeldung.com/spring-boot-actuators
## Version
- java: 17.0.11-tem
- maven: 3.9.8

