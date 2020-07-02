# clip-url
This is a basic REST API to shorten URLs, using in-memory H2 database with JPA and SpringBoot.

## How to Run 

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar -Dspring.profiles.active=test target/spring-boot-rest-example-0.5.0.war
or
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```
* Check the stdout or boot_example.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2020-07-01 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2020-07-01 17:31:23.097  INFO 19387 --- [           main] com.example.clipurl        : Started clipurl in 22.285 seconds (JVM running for 23.032)
```


Here are some endpoints you can call:

### Get information about url stored

```
http://localhost:8080/urls/shortUrlId
```

### Create a new shortened url

```
POST /urls
Accept: application/json
Content-Type: application/json

{
  "url" : "http://www.google.com"
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8080/urls/shortUrlId
BODY: contains the URL object with all the details.
```

### Redirect a shortened URL

```
http://localhost:8090/ABCD

REDIRECTED: original-url
```
