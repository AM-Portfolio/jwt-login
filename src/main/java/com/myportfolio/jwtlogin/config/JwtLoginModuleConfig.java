package com.myportfolio.jwtlogin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class for JWT Login module dependencies
 * This configuration will be imported when jwt-login is used as a JAR dependency
 */
@Configuration
@ComponentScan(basePackages = {
    "com.myportfolio.jwtlogin.controller",
    "com.myportfolio.jwtlogin.service",
    "com.myportfolio.jwtlogin.util",
    "com.myportfolio.jwtlogin.configuration"
})
@EnableJpaRepositories(basePackages = "com.myportfolio.jwtlogin.dao")
@EnableTransactionManagement
@EnableMethodSecurity(prePostEnabled = true)
public class JwtLoginModuleConfig {
    
    /**
     * Constructor for configuration class
     */
    public JwtLoginModuleConfig() {
        // Default constructor
    }
}
