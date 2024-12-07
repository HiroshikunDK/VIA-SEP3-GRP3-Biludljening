import Shared.ContextKeys;
import Shared.TokenValidation;
import io.grpc.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Base64;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TokenValidationTest {

    private static final String SECRET_KEY = Base64.getEncoder().encodeToString("DenErHemmelig".getBytes());
    private TokenValidation interceptor;
    private ServerCallHandler<Object, Object> mockHandler;
    private Metadata metadata;

    @BeforeEach
    void setup() {
        interceptor = new TokenValidation();
        mockHandler = mock(ServerCallHandler.class);
        metadata = new Metadata();
    }

    private String generateTestToken() {
        return Jwts.builder()
                .setSubject("TestUser")
                .claim("customerId", "123")
                .claim("role", "Customer")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour validity
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes()) // Use getBytes for signing key
                .compact();
    }

    @Test
    void testValidToken() {
        // Arrange
        String token = "Bearer " + generateTestToken();
        metadata.put(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER), token);

        ServerCall<Object, Object> mockCall = mock(ServerCall.class);
        ServerCall.Listener<Object> mockListener = mock(ServerCall.Listener.class);

        // Mock the ServerCallHandler to return the mocked listener
        when(mockHandler.startCall(any(ServerCall.class), any(Metadata.class))).thenReturn(mockListener);

        // Act
        ServerCall.Listener<Object> listener = interceptor.interceptCall(mockCall, metadata, mockHandler);

        // Assert
        assertNotNull(listener, "Listener should not be null");

        // Verify that startCall was invoked
        ArgumentCaptor<ServerCall> callCaptor = ArgumentCaptor.forClass(ServerCall.class);
        ArgumentCaptor<Metadata> metadataCaptor = ArgumentCaptor.forClass(Metadata.class);
        verify(mockHandler, times(1)).startCall(callCaptor.capture(), metadataCaptor.capture());

        System.out.println("Captured ServerCall: " + callCaptor.getValue());
        System.out.println("Captured Metadata: " + metadataCaptor.getValue());
    }


    @Test
    void testInvalidToken() {
        // Arrange
        String token = "Bearer invalid-token";
        metadata.put(Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER), token);
        ServerCall<Object, Object> mockCall = mock(ServerCall.class);

        // Act
        interceptor.interceptCall(mockCall, metadata, mockHandler);

        // Assert
        ArgumentCaptor<Status> statusCaptor = ArgumentCaptor.forClass(Status.class);
        ArgumentCaptor<Metadata> metadataCaptor = ArgumentCaptor.forClass(Metadata.class);

        verify(mockCall, times(1)).close(statusCaptor.capture(), metadataCaptor.capture());

        Status capturedStatus = statusCaptor.getValue();
        assertEquals(Status.UNAUTHENTICATED.getCode(), capturedStatus.getCode());
        assertEquals("Invalid token", capturedStatus.getDescription());
    }


    @Test
    void testMissingToken() {
        // Arrange
        ServerCall<Object, Object> mockCall = mock(ServerCall.class);

        // Act
        interceptor.interceptCall(mockCall, metadata, mockHandler);

        // Assert
        ArgumentCaptor<Status> statusCaptor = ArgumentCaptor.forClass(Status.class);
        verify(mockCall, times(1)).close(statusCaptor.capture(), any());

        Status capturedStatus = statusCaptor.getValue();
        assertEquals(Status.UNAUTHENTICATED.getCode(), capturedStatus.getCode());
        assertEquals("Missing or invalid token", capturedStatus.getDescription());
    }
}
