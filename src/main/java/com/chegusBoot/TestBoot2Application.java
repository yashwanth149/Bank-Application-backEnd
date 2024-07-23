package com.chegusBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestBoot2Application.class, args);
	}

}
