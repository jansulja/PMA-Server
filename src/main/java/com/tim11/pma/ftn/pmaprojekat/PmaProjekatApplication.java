package com.tim11.pma.ftn.pmaprojekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class PmaProjekatApplication {

	 @RequestMapping("/")
	    @ResponseBody
	    String home() {
	      return "Hello !";
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(PmaProjekatApplication.class, args);
	}
}
