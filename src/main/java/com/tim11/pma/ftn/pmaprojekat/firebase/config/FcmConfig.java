package com.tim11.pma.ftn.pmaprojekat.firebase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.bytefish.fcmjava.client.FcmClient;
import de.bytefish.fcmjava.http.client.IFcmClient;

@Configuration
public class FcmConfig {

	@Bean
	public IFcmClient fcmClient(FcmSettings settings) {
	  return new FcmClient(settings);
	}
	
}
