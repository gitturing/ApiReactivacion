package co.com.ccb.apirest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApirestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 String password = "12345";
		 for (int i = 0; i < 10; i++) {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	 
			 String passwordEncrypt = passwordEncoder.encode(password);
			 System.out.println(passwordEncrypt);
			 
		}
		
	}

}
