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

### 1. List all products

```http
GET /products
```

**Example Request:**
```bash
curl -X GET http://localhost:8080/products | jq
```

### 2. Retrieve a specific product by ID

```http
GET /products/{id}
```

**Example Request:**
```bash
curl -X GET http://localhost:8080/products/1 | jq
```

### 3. Add a new product

```http
POST /products
```

**Example Request:**
```bash
curl -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 21, "name": "New Product", "price": 500}' | jq
```

### 4. Update an existing product by ID

```http
PUT /products/{id}
```

**Example Request:**
```bash
curl -X PUT http://localhost:8080/products/1 -H "Content-Type: application/json" -d '{"id": 1, "name": "Updated Product", "price": 1600}' | jq
```

### 5. Remove a product by ID

```http
DELETE /products/{id}
```

**Example Request:**
```bash
curl -X DELETE http://localhost:8080/products/1 | jq
```

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```
