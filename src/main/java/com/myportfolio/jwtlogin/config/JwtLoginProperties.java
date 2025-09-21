package com.myportfolio.jwtlogin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for JWT Login module
 * These properties can be configured when jwt-login is used as a JAR dependency
 */
@Configuration
@ConfigurationProperties(prefix = "jwt.login")
public class JwtLoginProperties {

    /**
     * JWT secret key for token signing
     */
    private String secretKey = "mySecretKey12345";

    /**
     * JWT token expiration time in milliseconds
     */
    private long expiration = 3600000L; // 1 hour

    /**
     * Enable/disable JWT authentication
     */
    private boolean enabled = true;

    /**
     * Default constructor
     */
    public JwtLoginProperties() {
        // Default constructor
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
