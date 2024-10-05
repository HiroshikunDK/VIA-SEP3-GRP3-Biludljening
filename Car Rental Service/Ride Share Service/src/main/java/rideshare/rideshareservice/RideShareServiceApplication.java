package rideshare.rideshareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RideShareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideShareServiceApplication.class, args);
	}

}



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHelper {

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public static String hashPassword(String plainPassword) {
		return encoder.encode(plainPassword);
	}

	public static boolean verifyPassword(String plainPassword, String hashedPassword) {
		return encoder.matches(plainPassword, hashedPassword);
	}
}


<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-core</artifactId>
    <version>5.8.0</version>
</dependency>
