package MicroserviceConnection;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagedChannels {

    @Value("${grpc.user-service.host}")
    private String userServiceHost;

    @Value("${grpc.user-service.port}")
    private int userServicePort;

    @Value("${grpc.product-service.host}")
    private String productServiceHost;

    @Value("${grpc.product-service.port}")
    private int productServicePort;

    @Value("${grpc.order-service.host}")
    private String orderServiceHost;

    @Value("${grpc.order-service.port}")
    private int orderServicePort;

    @Value("${grpc.payment-service.host}")
    private String paymentServiceHost;

    @Value("${grpc.payment-service.port}")
    private int paymentServicePort;

    @Bean
    public ManagedChannel userServiceChannel() {
        return ManagedChannelBuilder.forAddress(userServiceHost, userServicePort)
                .usePlaintext() // Use plaintext for simplicity, change if using SSL
                .build();
    }

    @Bean
    public ManagedChannel productServiceChannel() {
        return ManagedChannelBuilder.forAddress(productServiceHost, productServicePort)
                .usePlaintext()
                .build();
    }

    @Bean
    public ManagedChannel orderServiceChannel() {
        return ManagedChannelBuilder.forAddress(orderServiceHost, orderServicePort)
                .usePlaintext()
                .build();
    }

    @Bean
    public ManagedChannel paymentServiceChannel() {
        return ManagedChannelBuilder.forAddress(paymentServiceHost, paymentServicePort)
                .usePlaintext()
                .build();
    }
}
