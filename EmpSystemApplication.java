package com.prog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication is a spring boot annotation which indicates a configuration 
//class that allows to declare one or more @Bean methods and also enables auto-configuration and component scanning.
@SpringBootApplication							
public class EmpSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpSystemApplication.class, args);  // this method starts whole Spring Framework.
	}

}