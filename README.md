# Testing a Controller in Spring Boot

In this simple application, in which we have a CRUD of products, 
I learned how to test or mock my Controller endpoints using MockWebServer 
instead of use Mockito in Spring boot.


Project structure:

```
── pom.xml
── src
    ├── main    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springmockingwebclient
    │   │                       ├─── controller
    │   │                       │       ├─── ExceptionHanlder.java
    │   │                       │       └─── ProductController.java
    │   │                       ├─── entities
    │   │                       │       ├─── ProductException.java
    │   │                       │       └─── Product.java
    │   │                       ├─── service
    │   │                       │       ├─── impl
    │   │                       │       │     └─── ProductServiceImpl.java
    │   │                       │       ├─── ProductService.java
    │   │                       └─── SpringMockingWebclientApplication.java
    ├───test    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springmockingwebclient
    │   │                       ├─── controller
    │   │                       │       └─── ProductControllerTest.java
    │   │                       └─── SpringMockingWebclientApplicationTests.java
    │   └─── resources
    │           ├─── application.properties
    │           ├─── static
    │           └─── templates
    │           
```

First of all, we have to include in the POM.xml file, the dependencies we need for the test.

```
<dependency>
   <groupId>com.squareup.okhttp3</groupId>
   <artifactId>okhttp</artifactId>
   <version>4.0.1</version>
   <scope>test</scope>
</dependency>
<dependency>
   <groupId>com.squareup.okhttp3</groupId>
   <artifactId>mockwebserver</artifactId>
   <version>4.0.1</version>
   <scope>test</scope>
</dependency>
```

Then, we have to add the MockWebServer to our test, and use the implementation of it

For more details about this proccess, please take a view for the **ProductControllerTest class.**

In this project we learned that:

1. There are two ways for mocking an endpoint and when trying to test a controller in Spring boot.
    * Using mockito to mimic the behaviour of WebClient is a bad decision 
      for this cause because of the nature of WebClient. WebClient is a 
      fluent API and it gets hard to mock every single behaviour of this process.
    * Using MockWebServer. It is a small web server that can receive and respond to HTTP requests.
      it really call the endpoint and we will not face issues like using mockito.

2. The MockWebServer in the test class is static, because we initialize it in the setUp method of the test which is static as well.

**NOTE**: Using MockWebServer is recommended by the Spring Team for writing **integration tests.**