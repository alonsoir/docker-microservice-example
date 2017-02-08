Travis CI [![Build Status](https://travis-ci.org/ismaelcabanas/docker-microservice-example.svg?branch=feature_travis_ci)](https://travis-ci.org/ismaelcabanas/docker-microservice-example)

# User Microservice Example

User Microservice Example es un microservicio escrito con Spring Boot que gestiona usuarios: alta, modificación, baja y lectura.

En esta rama concreta del proyecto se trata de probar el despliegue de una aplicación Spring Boot
en Heroku con Docker a través de un Dockerfile.

# Desarrollo

## Desarrollo local

### build

Se requiere tener instalado Java 8 y Maven 3.

Para construir el proyecto y ejecutar los tests ejecutar el comando

    mvn clean verify

