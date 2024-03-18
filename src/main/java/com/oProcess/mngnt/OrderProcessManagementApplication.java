package com.oProcess.mngnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class OrderProcessManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessManagementApplication.class, args);
	}

}
