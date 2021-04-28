package com.ktung.springkafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleProducer {

  @Value("${kafka.topic}")
  private String topic;

  private final KafkaTemplate<String, String> kafkaTemplate;

  private static final Logger LOG = LoggerFactory.getLogger(SimpleProducer.class);

  public SimpleProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send() {
    String msg = "Some data";
    this.kafkaTemplate.send(topic, msg);
    LOG.info(String.format("Message %s sent to topic %s", msg, topic));
  }
}
