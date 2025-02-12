package tn.esprit.spring.firstms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class FirstMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMsApplication.class, args);
	}

}
