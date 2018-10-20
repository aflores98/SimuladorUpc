package com.simulador.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class SimuladorApplication implements CommandLineRunner {

	//encripta para generar un password
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		//constructor
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();}
		
		
			
	public static void main(String[] args) {
		SpringApplication.run(SimuladorApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//Indico que el password sera del 1 al 9
		String password = "Upc2018@";
		
		for(int i=0; i<1; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			//Se muestra en la consola 2 encriptaciones cuyos valores son en realidad del 1 al 9
			System.out.println(bcryptPassword);
		}
	}
}
