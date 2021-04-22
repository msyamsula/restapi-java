# java-gradle

REQUIREMENTS
1. java extension pack (vscode extension)
2. gradle (brew install gradle)
3. Mysql database with user "root", password "mysql", dbname "gorm"
    Table Person (id, name, address, account_id)
    Table Account (id, username, password)
    Table Student (id, grades)
4. Spring initlzr: vscode extension
5. use appropriate java version: cmd+shift+p --> Java: Configure Java Runtime
mvn package:
6. spring-boot-starter-web: to activate rest api functionality
7. spring-boot-starter-security: for security reason
8. spring-boot-starter-data-jpa & hibernate & jpa & spring-data-jpa: to connect to database
9. spring-boot-devtools: for reload when developing
10. spring-boot-starter-actuator: healthcheck and etc for free

PROJECT INITIATION
1. after installing spring initlzr, cmd+shift+p -> create maven project
2. choose appropriate naming and package
3. java directory will be generated for you
4. start coding

TESTING APP

RUNNING APP
1. build the package: mvn package
2. run the jar file in the target directory


WHAT IS GRADLE AND MAVEN
1. gradle is one of java package manager, like pip in python, npm in javascript, go.mod in golang
2. the other popular java package manager is maven
3. maven quickstart : https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

NOTES
1. run gradle init in your root project directory and select your option
2. becarefull with your root project naming, don't start with "java"
3. after gradle init, root dir will be automatically handed to you project structure
4. you can run the template with ./gradlew run
5. build wiht ./gradlew build
6. hibernate.configuration example: https://www.tutorialspoint.com/hibernate/hibernate_configuration.htm
7. to run java app, run java jar from package build
    maven:
        run mvn package, specify with java 11 in pom
        run jar file in build folder in target/file.jar
8. mvn package repository: https://mvnrepository.com/, search all your need here
9. because of inversion of control (see documentation) entity manager is handled by spring
10. Json parsing in response, is handled automatically with spring. No need to bother unless you want to create you own response
11. for crud 101 please see Service/PersonServiceImpl.java
12. to handle Foreign key object mapping please see project linkaja2020
    or spring-boot/hibernate. There, you can see implementation of
    one to one
    one to many
    many to many
13. you can use 2 method to do crud in java without the help of spring-jpa
    a. with hibernate using hql
    b. with jpa using jpql
14. spring-jpa is package that give basic crud for free. eventhough spring-jpa give us crud for free, some scenaoria might demand a full control over the query so hql and jpql is better
15. spring-data-jpa is implemented in AccountRepository.java, (documentation no.5 list of all free service you get)
16. like spring-data-jpa, spring-data-rest is used to go further, giving you lesser boilerplate. it gives you endpoint
17. spring-data-rest, makes basic crud available with only your model and repository. Implementation of spring-data-rest is in Student.java
18. documentation no.6 gives you more insight how spring-data-rest work. see StudentModel.java and StudentRepository.java for the implementation


USEFUL COMMANDS
1. gradle init
2. gradlew run: run project
3. gradlew build: build project
4. mvn package: build with maven, run with "mvn package -X" if failed


JAVA ANNOTATION
1. @RestController: make package a rest controller
2. @GetMapping("url"): mapping function to "GET http://localhost/url"
3. @Table: specify the class is table mapping
4. @Column: map variable to table column
5. @Id: mark attribute as primary key
6. @GeneratedValue(strategy = GenerationType.IDENTITY): mark attribute as auto increment
7. @Transactional: create transactiona with database automatically in that function
8. @RequestParam "type" "name" : get variable from requestparam (args)
9. @Override: it means implement function of interface
10. @JsonProperty: specify json key for class attribute
11. @Respository: set class as repository
12. @Service: set class as service
13. @RepositoryRestResource(name = "path"): specify endpoint that is given by data rest
what i mean by repository is layer in java application
boilerplate java application is:
controller -> service -> dao/repository -> database(persistent)


DOCUMENTATION
1. https://www.tutorialsteacher.com/ioc: Inversion of Control Paradigm
2. https://docs.jboss.org/hibernate/orm/5.4/quickstart/html_single/#tutorial_annotations: Java ORM
3. https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html: Spring boot actuator
4. https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html: spring boot application.properties
5. https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html: spring-data-jpa
6. https://docs.spring.io/spring-data/rest/docs/current/reference/html/#repository-resources