# Steps of project running
1.Clone the project and go to root of the project and run - ` ./mvnw spring-boot:run` 
  #### You will see your project is successfully running!!
# Run by docker
1. build your image - `docker build -t portfolio .`
2. run your project on specific port - `docker run -d -p 8000:8080 portfolio portfolio-container`
### Self deployed live url
1. Live url - https://javab7-protfolio-deploy.onrender.com

### If you want to create jr file run:-  `mvn clean package`
### Run in production mode:- `java -jar target/javaB7-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod`
### (Optional) Run inside docker in dev mode:- `docker run -d --name myapp-dev-container -e SPRING_PROFILES_ACTIVE=dev -p 8080:8080 myapp-image`

### If you want to run this project by docker-compose: `docker-compose up -d` or down `docker-compose down`


## Learning Checklist
- [x] Java 17
- [ ] Core Concepts
    - [x] Servlet
    - [x] Convention over Configuration
    - [x] Inversion of Control (IoC)
    - [x] IoC Container
    - [x] Dependency Injection
    - [x] Application Context
    - [x] Bean
    - [x] DispatcherServlet
    - [ ] Interceptor
    - [ ] Filter
- [x] Server-Side (using Template Engine)
    - [x] / (Portfolio Homepage)
    - [ ] Practice Thymeleaf Tags
- [ ] REST API
    - [X] /api/projects (CRUD for Projects)
    - [ ] Secure Endpoints
    - [ ] Input Validation
    - [x] API Documentation: Swagger
    - [ ] API Paging and Sorting
- [ ] Exception
    - [x] Custom Exception Class
    - [ ] Global Exception Handler
- [ ] Logging
- [ ] External Service Call
- [ ] Boilerplate Code Reduce
    - [ ] Mapper for Mapping
    - [ ] Lombok for Generating Getters and Setters
- [ ] Spring Security
    - [ ] Basic Auth
    - [ ] JWT
- [ ] Database
    - [x] H2 (In-Memory Database)
    - [ ] PostgreSQL
- [x] Spring Profiles (local, dev, prod)
- [ ] Deployment
    - [x] Platform as-a Service (PaaS): [Render](https://portfolio-6nv7.onrender.com/)
    - [ ] Infrastructure as-a-Service (IaaS): Virtual Machine