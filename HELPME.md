# user-service API with Spring Boot


## Steps to Setup

**1. Clone the application**

```
$  git clone  https://github.com/atanu2110/user-service.git
```

**2. Build project using Maven**

```
$ mvn clean install -DskipTests
```

**3. Build docker image**

```
docker build -t user-service .
```

**4. Run docker image**

```
docker run -p 8087:8087 user-service
```

The app will start running at <http://localhost:8087>

## Api Documentation (Swagger)

<http://localhost:8086/swagger-ui/#/>