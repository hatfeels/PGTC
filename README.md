### Plataforma de Gestión de Tareas Colaborativas(provicional)

## Descripción del Proyecto

Este proyecto consiste en desarrollar una plataforma de gestión de tareas colaborativas utilizando el patrón de microservicios con Spring Boot. La plataforma permite a los usuarios crear, asignar, y seguir el progreso de tareas en tiempo real, además de ofrecer comunicación instantánea entre los usuarios.

## Arquitectura del Proyecto

- **Microservicios**: Spring Boot
- **Orquestación de Contenedores**: Kubernetes
- **Contenedores**: Docker
- **API Gateway**: Spring Cloud Gateway
- **Service Discovery**: Netflix Eureka
- **Configuración Centralizada**: Spring Cloud Config
- **Roles y Autenticación**: Spring Security

## Estructura de Microservicios

1. **User Service**: Manejo de usuarios y autenticación.
2. **Task Service**: Gestión de tareas.
3. **Notification Service**: Notificaciones en tiempo real.
4. **Chat Service**: Sistema de chat en tiempo real.
5. **Gateway Service**: API Gateway.
6. **Config Service**: Configuración centralizada.
7. **Discovery Service**: Service Discovery.

## Tecnologías Utilizadas

- **Spring Boot**
- **Spring Cloud Gateway**
- **Netflix Eureka**
- **Spring Cloud Config**
- **RabbitMQ / Kafka**
- **PostgreSQL**
- **Docker**
- **Kubernetes**
- **Prometheus**
- **Grafana**
- **ELK Stack (Elasticsearch, Logstash, Kibana)**
- **Swagger / SpringDoc OpenAPI**

## Requisitos Previos

- Java 11 o superior
- Docker
- Kubernetes (Minikube para desarrollo local)
- Maven o Gradle
- Git

## Paso a Paso para Desarrollar el Proyecto

### 1. Configuración Inicial

#### Clonar el Repositorio

```sh
git clone https://github.com/hatfeels/PGTC.git
cd PGTC
```

### 2. Desarrollo de Microservicios

#### 2.1. User Service

1. Crear el proyecto Spring Boot:

```sh
spring init --dependencies=web,security,data-jpa,postgresql --name=user-service user-service
cd user-service
```

2. Configurar `application.yml` para conexión a PostgreSQL y otras configuraciones:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/userdb
    username: yourusername
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

3. Implementar las entidades, repositorios, servicios y controladores necesarios.

4. Crear un Dockerfile:

```Dockerfile
FROM openjdk:11-jre-slim
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
```

5. Construir y empaquetar:

```sh
mvn clean package
docker build -t user-service .
```

#### 2.2. Task Service

1. Crear el proyecto Spring Boot:

```sh
spring init --dependencies=web,data-jpa,postgresql --name=task-service task-service
cd task-service
```

2. Configurar `application.yml` para conexión a PostgreSQL.

3. Implementar las entidades, repositorios, servicios y controladores necesarios.

4. Crear un Dockerfile y construir la imagen Docker.

#### 2.3. Notification Service

1. Crear el proyecto Spring Boot:

```sh
spring init --dependencies=web,amqp --name=notification-service notification-service
cd notification-service
```

2. Configurar `application.yml` para RabbitMQ.

3. Implementar la lógica de notificaciones usando Spring AMQP.

4. Crear un Dockerfile y construir la imagen Docker.

#### 2.4. Chat Service

1. Crear el proyecto Spring Boot:

```sh
spring init --dependencies=web,websocket --name=chat-service chat-service
cd chat-service
```

2. Configurar WebSocket en `application.yml`.

3. Implementar la lógica de WebSocket y STOMP.

4. Crear un Dockerfile y construir la imagen Docker.

#### 2.5. Gateway Service

1. Crear el proyecto Spring Boot:

```sh
spring init --dependencies=cloud-gateway --name=gateway-service gateway-service
cd gateway-service
```

2. Configurar el enrutamiento en `application.yml`.

3. Crear un Dockerfile y construir la imagen Docker.

#### 2.6. Config Service

1. Crear el proyecto Spring Boot:

```sh
spring init --dependencies=cloud-config-server --name=config-service config-service
cd config-service
```

2. Configurar el servidor de configuración en `application.yml`.

3. Crear un Dockerfile y construir la imagen Docker.

#### 2.7. Discovery Service

1. Crear el proyecto Spring Boot:

```sh
spring init --dependencies=cloud-eureka-server --name=discovery-service discovery-service
cd discovery-service
```

2. Configurar Eureka en `application.yml`.

3. Crear un Dockerfile y construir la imagen Docker.

### 3. Orquestación con Kubernetes

1. Crear archivos de configuración YAML para Kubernetes (deployment.yml, service.yml) para cada microservicio.

2. Implementar los despliegues y servicios en el clúster de Kubernetes:

```sh
kubectl apply -f deployment.yml
kubectl apply -f service.yml
```

### 4. Monitoreo y Logging

1. Configurar Prometheus y Grafana para monitoreo.
2. Configurar ELK Stack para logging centralizado.

### 5. Pruebas y Documentación

1. Implementar pruebas unitarias y de integración utilizando JUnit y Mockito.
2. Documentar las API's con Swagger y SpringDoc OpenAPI.

### 6. Integración Continua / Entrega Continua (CI/CD)

1. Configurar pipelines de CI/CD utilizando Jenkins, GitHub Actions, o GitLab CI/CD para automatizar la construcción, pruebas y despliegue.

### 7. Despliegue en Producción

1. Configurar un entorno de producción en la nube (AWS, Google Cloud, Azure).
2. Desplegar los microservicios en el entorno de producción utilizando Kubernetes.

### Contacto

Para cualquier duda o sugerencia, puedes contactarme a través [ayrton.torres.1995@gmail.com].

---

¡Disfruta desarrollando y utilizando la plataforma de gestión de tareas colaborativas!
# PGTC
# PGTC
