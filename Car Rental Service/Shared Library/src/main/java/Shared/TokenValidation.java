package Shared;

import io.grpc.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import java.util.Base64;

public class TokenValidation implements ServerInterceptor {
    private static final String RAW_SECRET_KEY = "DenErHemmelig"; // Original key
    private static final String BASE64_SECRET_KEY = Base64.getEncoder().encodeToString(RAW_SECRET_KEY.getBytes()); // Base64-encoded
    private static final byte[] DECODED_SECRET_KEY = Base64.getDecoder().decode(BASE64_SECRET_KEY); // Decoded bytes
    private static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY =
            Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next
    ) {
        // Retrieve the Authorization header
        String token = headers.get(AUTHORIZATION_METADATA_KEY);

        System.out.println("Authorization Header: " + token);

        // Validate the token
        if (token == null || !token.startsWith("Bearer ")) {
            System.out.println("Missing or invalid token");
            call.close(Status.UNAUTHENTICATED.withDescription("Missing or invalid token"), new Metadata());
            return new ServerCall.Listener<>() {}; // No-op listener
        }

        token = token.substring(7); // Remove "Bearer " prefix

        try {
            // Parse and validate the token
            Claims claims = Jwts.parser()
                    .setSigningKey(DECODED_SECRET_KEY) // Use decoded secret key
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println("Token is valid. Claims: " + claims);
            System.out.println("Token Subject: " + claims.getSubject());
            System.out.println("Token Expiration: " + claims.getExpiration());

            // Add claims to the gRPC Context
            Context context = Context.current()
                    .withValue(ContextKeys.CUSTOMER_ID, claims.get("customerId", String.class))
                    .withValue(ContextKeys.ROLE, claims.get("role", String.class));

            // Pass the modified context to the next handler
            return Contexts.interceptCall(context, call, headers, next);

        } catch (SignatureException ex) {
            System.out.println("Invalid token signature: " + ex.getMessage());
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid token"), new Metadata());
            return new ServerCall.Listener<>() {}; // No-op listener
        } catch (Exception ex) {
            System.out.println("Error validating token: " + ex.getMessage());
            call.close(Status.UNAUTHENTICATED.withDescription("Error validating token"), new Metadata());
            return new ServerCall.Listener<>() {}; // No-op listener
        }
    }
}
