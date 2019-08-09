package com.raju.micro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(MicroServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Application starting...");
		SpringApplication.run(MicroServiceApplication.class, args);
	}

}
