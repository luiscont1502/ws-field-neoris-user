package com.neoris.service;

import com.neoris.service.source.PostgresConfig;
import com.neoris.service.source.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({PostgresConfig.class, WebConfig.class})
public class WsFieldNeorisUserApplication {

	public static void main(String[] args) {

		SpringApplication.run(WsFieldNeorisUserApplication.class, args);
	}

}
