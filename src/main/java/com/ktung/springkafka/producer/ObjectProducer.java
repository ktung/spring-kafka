package com.ktung.springkafka.producer;

import com.ktung.springkafka.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ObjectProducer {

  @Value("${kafka.object-topic}")
  private String topic;

  private final KafkaTemplate<String, Event> kafkaTemplate;

  private static final Logger LOG = LoggerFactory.getLogger(ObjectProducer.class);

  public ObjectProducer(KafkaTemplate<String, Event> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send() {
    Event event = new Event(1L, "Name Event");
    Random random = new Random();
    this.kafkaTemplate.send(topic, String.valueOf(random.nextInt(100)), event);
    LOG.info(String.format("Message %s sent to topic %s", event, topic));
  }
}
