# E-Shop
WEB for Spring MVC learning

### Requirements
* Language JDK 17
* Check if JAVA_HOME used JDK 17

## Run DB with Docker
### Run MySQL
```
docker compose up -d mysqldb
```

### Run postgres
```
docker compose up -d postgresqldb
```

### Run pgAdmin for posgres
```
docker compose -d pgadmin4
```

## Run application using spring-boot
### on H2 DB
```
./mvnw spring-boot:run
```

### on MySQL DB
```
./mvnw spring-boot:run -Dspring.profiles.active=mysql
```

### on PostgreSQL DB
```
./mvnw spring-boot:run -Dspring.profiles.active=pg
```

## Access the app
http://localhost:8080