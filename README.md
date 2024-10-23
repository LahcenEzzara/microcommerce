# microcommerce - Product Management API

This project is a simple RESTful API for managing products. It allows users to perform basic CRUD (Create, Read, Update, Delete) operations on products.

## Project Setup

To set up this project locally, you can use the [Spring Initializr](https://start.spring.io/) to generate the project structure with the necessary dependencies.

### Dependencies

The following dependencies are included in the project:

- **Spring Web**: For building web applications, including RESTful services.
- **Spring DevTools**: For enhancing the development experience with automatic restarts and live reload.

### Steps to Create the Project

1. Go to [Spring Initializr](https://start.spring.io/).
2. Fill in the details as follows:
   - **Project**: Maven Project
   - **Language**: Java
   - **Spring Boot**: 3.3.4
   - **Packaging**: Jar
   - **Java**: 17
   - **Group**: `com.ecommerce`
   - **Artifact**: `microcommerce`
   - **Name**: `microcommerce`
   - **Description**: A RESTful API for managing products with basic CRUD operations. Built for microservices architecture.
   - **Package Name**: `com.ecommerce.microcommerce`
3. Add the required dependencies:
   - Spring Web
   - Spring DevTools
4. Click on the **Generate** button to download the project as a ZIP file.
5. Extract the ZIP file and open it in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).
6. Build and run the application.

## Features

- List all products
- Retrieve a specific product by ID
- Add a new product
- Update an existing product by ID
- Remove a product by ID

## API Endpoints

### 1. List all products - GET /products

```bash
curl -X GET http://localhost:8080/products | jq
```

### 2. Retrieve a specific product by ID - GET /products/{id}

```bash
curl -X GET http://localhost:8080/products/1 | jq
```

### 3. Add a new product - POST /products

```bash
curl -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 21, "name": "New Product", "price": 500}' | jq
```

### 4. Update an existing product by ID - PUT /products/{id}

```bash
curl -X PUT http://localhost:8080/products/1 -H "Content-Type: application/json" -d '{"id": 1, "name": "Updated Product", "price": 1600}' | jq
```

### 5. Remove a product by ID - DELETE /products/{id}

```bash
curl -X DELETE http://localhost:8080/products/1 | jq
```

## Docker Setup

### Step 1: Create the JAR File

To create a JAR file for the project, ensure you have [Maven](https://maven.apache.org/) installed. Then, navigate to the root of your project directory and run the following command:

```bash
cd microcommerce
mvn clean package -DskipTests
```

After executing this command, the JAR file will be generated in the `target` directory, typically named `microcommerce-0.0.1-SNAPSHOT.jar`.

### Step 2: Create a Docker Image

To create a Docker image for your Spring Boot application, you need a `Dockerfile`. In the root of your project directory, create a file named `Dockerfile` with the following content:

```dockerfile
# Use a base image that includes Java
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build output (JAR file) to the container
COPY target/microcommerce-0.0.1-SNAPSHOT.jar microcommerce.jar

# Expose the application port
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "microcommerce.jar"]
```

Then, build the Docker image using the following command:

```bash
docker build -t microcommerce-image .
```

### Step 3: Create and Run a Docker Container

Once the Docker image is built, you can create and run a Docker container using the following command:

```bash
docker run -d -p 8080:8080 --name microcommerce-container microcommerce-image
```

- This command will run the container in detached mode, mapping port 8080 on your host to port 8080 in the container.

### Accessing the Application

After the container is running, you can access the Spring Boot application at:

```
http://localhost:8080/products
```

### Stopping and Removing the Container

To stop the running container, use the following command:

```bash
docker stop microcommerce-container
```

To remove the container, use:

```bash
docker rm microcommerce-container
```

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.