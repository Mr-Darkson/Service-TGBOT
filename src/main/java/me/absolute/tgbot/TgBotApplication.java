package me.absolute.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TgBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgBotApplication.class, args);
	}

}
