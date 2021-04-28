package com.ktung.springkafka.consumer;

import com.ktung.springkafka.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectConsumer {

  private static final Logger LOG = LoggerFactory.getLogger(ObjectConsumer.class);

  @KafkaListener(topics = "${kafka.object-topic}")
  public void processMessage(Event event,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions) {
    LOG.info(String.format("Partition %d : Receive event %s", partitions.get(0), event.getName()));
  }
}
