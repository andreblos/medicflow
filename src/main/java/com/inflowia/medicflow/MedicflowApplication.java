package com.inflowia.medicflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.inflowia.medicflow")
public class MedicflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicflowApplication.class, args);
	}

}
