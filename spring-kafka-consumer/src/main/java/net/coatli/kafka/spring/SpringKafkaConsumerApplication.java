package net.coatli.kafka.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringKafkaConsumerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SpringKafkaConsumerApplication.class, args);
	}
}
