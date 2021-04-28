package com.ktung.springkafka;

import com.ktung.springkafka.producer.SimpleProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(SimpleProducer producer) {
		return args -> {
			for (int i = 0; i < 20; i++) {
				producer.send();
			}
		};
	}

}
