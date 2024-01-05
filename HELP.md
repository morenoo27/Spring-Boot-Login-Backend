<h1 align="center">Help Annotations</h1>

Additional info to care about before start in this project

These annotations are intended for programmers, for things they should know before dealing with the project code.

<h2 align="center">Table of Contents</h2>

- [Reference Documentation](#reference-documentation)
- [Guides](#guides)
- [Database (Important)](#database-important)
- [More Documentation](#more-documentation)
  - [Requirements](#requirements)
  - [Profile Settings](#profile-settings)
  - [Project configuration (set a profile)](#project-configuration-set-a-profile)

## Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
- [Spring Security](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web.security)

## Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
- [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
- [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
- [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

## Database (Important)

This project has to be connected to a Database, this si a simulation of al login for any application that needs a previous authorization, so this project _simulates_ the needed code to catch that request from client and check if the credentials are valid or not.

> Please note that this project is a template, you have to write your own authorization <br/> (You can follow some comments I left in code for that)

## More Documentation

Here will be some points from author to care about this project and his ejecution to dev ussages.

### Requirements

**Java v17** - Its the languaje of the project, so you need to have installed in your device this version of java.

> You can check if you have it executing next command

```java
java --version
```

### Profile Settings

We have a folder in project, called `resources` where there are some files with extension `*.properties`

In this files we have the configuration of conections of _database, rabbit, mails, etc_

You can use `application.properties` to set some configuration common to all project, but if you want some especific configuration you can create `aplication-*name-of-profile*.properties` to create a new profile

> To call the profile in project configuration, only call name after `-` in file name

### Project configuration (set a profile)

> We have two ways to execute this project in local, we can use `Eclipse IDE` or `Visual Studio Code` here we will show how to do it in each one

- Eclipse IDE

    Here we have a section called _Boot Dashboard_. All our imported and open projects will appear here.

    To run one of them locally you need to set up a profile in `Open Config` and
    the `profile` selector and then run it

- Visual Studio Code

    To configure the project profile, you need to configure the `launch.json` file in the `./.vscode` folder.

    To select a profile, go to prop "arg" and set value `X` to the profile you want to use

```json
"args": "--spring.profiles.active=X"
```

> Same as Eclipse, but the difference is the way to set the profile

**IMPORTANT!**
> Its recomendable always test in local profile with local conections (database, queue conections, etc)
