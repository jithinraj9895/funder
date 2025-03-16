package com.fts.funder;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FunderApplication {

	static {
		Dotenv env = Dotenv.load();
		env.entries().forEach(entry->System.setProperty(entry.getKey(), entry.getValue()));
	}

	public static void main(String[] args) {
		SpringApplication.run(FunderApplication.class, args);
	}
}
