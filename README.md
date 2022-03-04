# Template project for future features

This simple application was develop for clone to futures features.
Instead of doing the same project structure and write the sames classes
we have this project for just download and integrate wathever we want.

In futures, the idea is to create a maven plugin which do a main task and create 
the structure.


Project structure:

```
── pom.xml
── src
    ├── main    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springscaffoldproject
    │   │                       ├─── config
    │   │                       ├─── controller
    │   │                       │       └─── ProductController.java
    │   │                       ├─── entities
    │   │                       │       └─── Product.java
    │   │                       ├─── exceptions
    │   │                       │       ├─── ProductException.java
    │   │                       │       └─── ProductExceptionController.java
    │   │                       ├─── services
    │   │                       │       └─── ProductService.java
    │   │                       └─── SpringScaffoldProjectApplication.java
    ├───test    
    │   ├─── java
    │   │       └─── laurens
    │   │             └─── poc    
    │   │                    └─── springscaffoldproject
    │   │                       ├─── controller
    │   │                       │       └─── ProductControllerTest.java
    │   │                       └─── SpringScaffoldProjectApplicationTests.java
    │   └─── resources
    │           ├─── application.properties
    │           ├─── static
    │           └─── templates
    │           
```
