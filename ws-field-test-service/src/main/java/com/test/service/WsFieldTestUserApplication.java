package com.test.service;

import com.test.service.source.PostgresConfig;
import com.test.service.source.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({PostgresConfig.class, WebConfig.class})
public class WsFieldTestUserApplication {

	public static void main(String[] args) {

		SpringApplication.run(WsFieldTestUserApplication.class, args);
	}

}
