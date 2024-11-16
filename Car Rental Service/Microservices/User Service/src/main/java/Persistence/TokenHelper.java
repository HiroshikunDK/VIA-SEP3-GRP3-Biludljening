package Persistence;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenHelper {
    private static final String SECRET_KEY = "DenErHemmelig";

    public static String generateToken(String username, String role) {
        long expirationTime = 1000 * 60 * 60;

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
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
