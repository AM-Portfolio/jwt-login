package com.myportfolio.jwtlogin.util;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

public class JwtUtilTest {

    @Test
    public void testJwtValidation() {
        String jwt =
"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmM3IiwiaWF0IjoxNzU4MDE3Njk4LCJleHAiOjE3NTgwMzU2OTh9.XOkRWCW7cQ5lE_eOHsHHoEVLLsH8PTqhQWlDxuT0qa3Unit5cYa9ZQEXZeUi-UbPLDtAPG56GyvqhIs29e3xoA";

        try {
            Claims claims = JwtUtil.verifyToken(jwt);
            if (claims != null) {
                System.out.println("✅ Token is valid");
                System.out.println("Subject: " + claims.getSubject());
                System.out.println("Issued At: " + claims.getIssuedAt());
                System.out.println("Expiration: " + claims.getExpiration());
            } else {
                System.out.println("❌ Invalid token: claims is null");
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid token: " + e.getMessage());
        }
    }
}
