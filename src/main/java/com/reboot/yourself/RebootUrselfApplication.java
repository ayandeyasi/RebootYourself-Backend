package com.reboot.yourself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.reboot.yourself" })
public class RebootUrselfApplication {

	public static void main(String[] args) {
		SpringApplication.run(RebootUrselfApplication.class, args);
	}
}
