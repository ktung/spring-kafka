package com.ktung.springkafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleConsumer {

  private static final Logger LOG = LoggerFactory.getLogger(SimpleConsumer.class);

  @KafkaListener(topics = "${kafka.topic}")
  public void processMessage(String message,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions) {
    LOG.info(String.format("Partition %d : Receive message %s", partitions.get(0), message));
  }
}
