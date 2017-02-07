package net.coatli.kafka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.coatli.kafka.spring.producer.Sender;

@SpringBootApplication
public class SpringKafkaProducerApplication implements CommandLineRunner {

  @Autowired
  private Sender producer;

	public static void main(final String[] args) {
		SpringApplication.run(SpringKafkaProducerApplication.class, args);
	}

  @Override
  public void run(final String... args) throws Exception {
    producer.sendMessage("example.t", "Hello Spring - Kafka!");
  }
}
