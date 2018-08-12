package com.prakash.wordcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.prakash" })
public class WordCountBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordCountBootApplication.class, args);
	}

}