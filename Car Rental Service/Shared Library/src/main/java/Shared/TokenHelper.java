package Shared;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;

public class TokenHelper {
    private static final String RAW_SECRET_KEY = "DenErHemmelig"; // Original key
    private static final String BASE64_SECRET_KEY = Base64.getEncoder().encodeToString(RAW_SECRET_KEY.getBytes()); // Base64-encoded
    private static final byte[] DECODED_SECRET_KEY = Base64.getDecoder().decode(BASE64_SECRET_KEY); // Decoded bytes

    public static String generateToken(String username, String role, int customerId) { // Add customerId
        long expirationTime = 1000 * 60 * 60; // 1 hour

        System.out.println("Base64 Encoded Key: " + BASE64_SECRET_KEY);

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("id", customerId) // Include CustomerId as a claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, DECODED_SECRET_KEY) // Use decoded key bytes
                .compact();
    }

    public static Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(DECODED_SECRET_KEY) // Use decoded key bytes
                .parseClaimsJws(token)
                .getBody();
    }

    public static boolean isTokenExpired(String token) {
        return validateToken(token).getExpiration().before(new Date());
    }

    public static boolean isAuthorized(String token, String requiredRole) {
        Claims claims = validateToken(token);
        String userRole = claims.get("role", String.class);
        return userRole.equals(requiredRole);
    }
}
