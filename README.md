# Steps of project running
1.Clone the project and go to root of the project and run - ` ./mvnw spring-boot:run` 
  #### You will see your project is successfully running!!
# Run by docker
1. build your image - `docker build -t portfolio .`
2. run your project on specific port - `docker run -d -p 8000:8080 portfolio portfolio-container`
# Self deployed live url
1. Live url - https://javab7-protfolio-deploy.onrender.com

# If you want to create jr file run:-  `mvn clean package`
# Run in production mode:- `java -jar target/javaB7-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod`
# Run inside docker in dev mode:- `docker run -d --name myapp-dev-container -e SPRING_PROFILES_ACTIVE=dev -p 8080:8080 myapp-image`
