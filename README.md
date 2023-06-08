### Gradle

```gradle
repositories {
    maven{
        url = uri("https://repo.emirman.dev/repository/maven-public/")
    }
}

dependencies {
    implementation 'dev.emirman.util:response:1.0.0'
}

```

### Class: Response

The `Response` class represents a response object that contains a message, status, code, and details. It provides methods to set and retrieve these properties.

#### Usage Example:
```java
Response response = new Response();
response.setMessage("Success");
response.setStatus(HttpStatus.OK);
response.setCode("200");
response.setDetails(new TreeMap<>());

// or using the constructor
Response response = new Response("Success", HttpStatus.OK, "200", new TreeMap<>());
```

### Class: ResponseBuilder

The `ResponseBuilder` class is a builder pattern implementation for creating `Response` objects. It provides methods to set the message, status, code, and details, and a `build()` method to construct the `Response` object.

#### Usage Example:
```java
ResponseBuilder builder = ResponseBuilder.newBuilder();
builder.withMessage("Success");
builder.withStatus(HttpStatus.OK);
builder.withCode("200");
builder.withDetails(new TreeMap<>());
Response response = builder.build();
```

### Class: PageResponse

The `PageResponse` class is a generic class that represents a response object for paginated data. It contains a `Page` object representing the data and a list of responses. It also provides a method `of()` to create a `Response` object with specific details.

#### Usage Example:
```java
Page<User> data = new Page<>();
List<RUser> dtos = new ArrayList<>();
// Populate data and response lists

PageResponse<User, RUser> pageResponse = new PageResponse<>(data, dtos);
Response response = pageResponse.of("users", "users successfully listed.");
```

Note: The above code snippets are simplified examples to demonstrate the usage of the classes. Actual implementation details and additional methods might be present based on the full code context.
