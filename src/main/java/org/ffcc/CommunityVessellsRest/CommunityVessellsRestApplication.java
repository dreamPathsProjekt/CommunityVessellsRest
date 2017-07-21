package org.ffcc.CommunityVessellsRest;

import org.ffcc.CommunityVessellsRest.services.StorageProperties;
import org.ffcc.CommunityVessellsRest.services.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CommunityVessellsRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityVessellsRestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
            storageService.init();
		};
	}
}
