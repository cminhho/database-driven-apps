package main.java.com.hmchung.ddd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.gotechmind.hateos")
public class SpringBootRestApp {
	private static final Logger log = LoggerFactory.getLogger(SpringBootRestApp.class);
	
	public static void main(String args[]) {
		SpringApplication.run(SpringBootRestApp.class, args);
	}
}
