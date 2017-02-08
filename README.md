Travis CI [![Build Status](https://travis-ci.org/ismaelcabanas/docker-microservice-example.svg?branch=feature_deploy_heroku)](https://travis-ci.org/ismaelcabanas/docker-microservice-example)

# User Microservice Example

User Microservice Example es un microservicio escrito con Spring Boot que gestiona usuarios: alta, modificación, baja y lectura.

En esta rama concreta del proyecto se trata de probar la integración contínua 
con Travis CI y el despliegue automático, si el build es correcto, a Heroku. Travis se encargará de realizar el build y deploy de nuestro proyecto
cuando se realice un push a Github sobre la rama.

Este es el proyecto ejemplo de la entrada del [blog](https://pajarokillo.wordpress.com/2017/02/07/desplegar-una-aplicacion-spring-boot-en-heroku/). 

# Desarrollo

## Desarrollo local

### build

Se requiere tener instalado Java 8 y Maven 3.

Para construir el proyecto y ejecutar los tests ejecutar el comando

    mvn clean verify

