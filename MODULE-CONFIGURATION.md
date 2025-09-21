# JWT Login Module Configuration

This document explains how to use the jwt-login module as a JAR dependency in other Spring Boot applications.

## Auto-Configuration

The jwt-login module provides auto-configuration that will be automatically loaded when the JAR is included in your project's classpath. The auto-configuration includes:

- JWT utility components
- Security configurations
- Service and controller components
- JPA repositories for user and role management

## Usage

### 1. Add Dependency

Add the jwt-login JAR to your project's dependencies:

**Maven:**
```xml
<dependency>
    <groupId>com.myportfolio</groupId>
    <artifactId>jwt-login</artifactId>
    <version>1.0.3-SNAPSHOT</version>
</dependency>
```

**Gradle:**
```gradle
implementation 'com.myportfolio:jwt-login:1.0.3-SNAPSHOT'
```

### 2. Configuration Properties

The module can be configured using the following properties in your `application.properties` or `application.yml`:

```properties
# Enable/disable JWT login module (default: true)
jwt.login.enabled=true

# JWT secret key for token signing (default: mySecretKey12345)
jwt.login.secret-key=your-secret-key-here

# JWT token expiration time in milliseconds (default: 3600000 = 1 hour)
jwt.login.expiration=3600000
```

### 3. Auto-Configuration Details

The auto-configuration will be loaded if:
- `JwtUtil` class is found on the classpath
- `jwt.login.enabled` is true (or not specified)
- No existing `JwtLoginModuleConfig` bean is present

### 4. Components Provided

When the module is loaded, the following components are automatically available:

#### Controllers:
- `JwtController` - Authentication endpoint (`/authenticate`)
- `UserController` - User management endpoints
- `RoleController` - Role management endpoints

#### Services:
- `JwtService` - JWT token creation and authentication
- `UserService` - User management operations
- `RoleService` - Role management operations

#### Utilities:
- `JwtUtil` - JWT token parsing, validation, and creation
- `JwtRequestFilter` - JWT authentication filter
- `JwtAuthenticationEntryPoint` - Authentication entry point

#### Security Configuration:
- Web security configuration with JWT authentication
- Method-level security annotations support
- CORS configuration

### 5. Database Configuration

The module uses JPA repositories for user and role management. Ensure your application has:

- A configured data source
- JPA/Hibernate configuration
- Database tables for `User` and `Role` entities

### 6. Example Usage

In your parent application, you can inject and use JWT components:

```java
@RestController
public class MyController {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @GetMapping("/verify-token")
    public ResponseEntity<Claims> verifyToken(@RequestHeader("Authorization") String token) {
        try {
            Claims claims = JwtUtil.verifyToken(token.substring(7)); // Remove "Bearer "
            return ResponseEntity.ok(claims);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
```

### 7. Disabling Auto-Configuration

To disable the auto-configuration, set:

```properties
jwt.login.enabled=false
```

Or exclude the auto-configuration class:

```java
@SpringBootApplication(exclude = {JwtLoginAutoConfiguration.class})
public class MyApplication {
    // ...
}
```

## Security Considerations

- Always use a strong, unique secret key in production
- Configure appropriate token expiration times
- Ensure database credentials are properly secured
- Review and customize security configurations as needed for your application

## Module Structure

```
com.myportfolio.jwtlogin
├── config/
│   ├── JwtLoginAutoConfiguration.java
│   ├── JwtLoginModuleConfig.java
│   └── JwtLoginProperties.java
├── controller/
│   ├── JwtController.java
│   ├── UserController.java
│   └── RoleController.java
├── service/
│   ├── JwtService.java
│   ├── UserService.java
│   └── RoleService.java
├── util/
│   └── JwtUtil.java
├── configuration/
│   ├── WebSecurityConfiguration.java
│   ├── JwtRequestFilter.java
│   └── JwtAuthenticationEntryPoint.java
├── dao/
│   ├── UserDao.java
│   └── RoleDao.java
└── entity/
    ├── User.java
    ├── Role.java
    ├── JwtRequest.java
    └── JwtResponse.java
```
