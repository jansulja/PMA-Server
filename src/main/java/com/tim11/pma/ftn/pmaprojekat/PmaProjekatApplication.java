package com.tim11.pma.ftn.pmaprojekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.tim11.pma.ftn.pmaprojekat")
public class PmaProjekatApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PmaProjekatApplication.class, args);
	}
}
