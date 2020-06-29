package com.dbs.ordercervice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DBS_OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBS_OrderServiceApplication.class, args);
	}
}
