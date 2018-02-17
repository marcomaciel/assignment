Assignment Java
===================

# Dependencies
* JDK 8
* Maven 3

# Build and Test
On the project directory, run:
```bash
> mvn package
```

# Test only
On the project directory, run:
```bash
> mvn test
```

# Run
On the project directory, run:
```bash
> java -jar target/assignment-0.1.jar
```

# Usage
You can use http://getpostman.com to use the services.
The application runs on localhost:8080 and it has the following endpoints:

>**GET**:   http://localhost:8080/v1/diff/{id}

>**POST**:  http://localhost:8080/v1/diff/{id}/left

>**POST**:  http://localhost:8080/v1/diff/{id}/right

>**GET**:   http://localhost:8080/v1/data/{id}

# Example
You can use the data below in the body of service for testing

> data 1: eyJuYW1lIjoiSm9obiIsImFnZSI6MzAsImNpdHkiOiJVdHJlY2h0In0 
> data 2: eyJuYW1lIjoiSm9obiIsImFnZSI6MzEsImNpdHkiOiJVdHJlY2h0In0
> data 3: eyJuYW1lIjoiSm9obiIsImFnZSI6MzAsImNpdHkiOiJJSnNzZWxzdGVpbi9VdHJlY2h0In0=