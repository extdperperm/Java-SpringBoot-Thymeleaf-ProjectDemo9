package es.dsw.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "es.dsw")
public class TSpringBootProjectDemo9Application {

	public static void main(String[] args) {
		SpringApplication.run(TSpringBootProjectDemo9Application.class, args);
	}

}
