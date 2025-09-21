package com.myportfolio.jwtlogin.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import com.myportfolio.jwtlogin.util.JwtUtil;

/**
 * Auto-configuration for JWT Login module
 * This will be automatically loaded when jwt-login JAR is on the classpath
 */
@AutoConfiguration
@ConditionalOnClass(JwtUtil.class)
@ConditionalOnProperty(prefix = "jwt.login", name = "enabled", havingValue = "true", matchIfMissing = true)
@ConditionalOnMissingBean(type = "com.myportfolio.jwtlogin.config.JwtLoginModuleConfig")
@EnableConfigurationProperties(JwtLoginProperties.class)
@Import({JwtLoginModuleConfig.class, JwtLoginProperties.class})
public class JwtLoginAutoConfiguration {
    
    /**
     * Constructor for auto-configuration class
     */
    public JwtLoginAutoConfiguration() {
        // Default constructor
    }
}
