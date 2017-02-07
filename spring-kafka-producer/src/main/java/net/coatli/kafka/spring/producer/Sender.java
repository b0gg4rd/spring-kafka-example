package net.coatli.kafka.spring.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  private final KafkaTemplate<Integer, String> kafkaTemplate;

  @Autowired
  public Sender(final KafkaTemplate<Integer, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(final String topic, final String message) {

    kafkaTemplate.send(topic, message)
      .addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

        @Override
        public void onSuccess(final SendResult<Integer, String> result) {
          LOGGER.info("sent message='{}' with offset={}", message, result.getRecordMetadata().offset());
        }

        @Override
        public void onFailure(final Throwable exc) {
          LOGGER.error("unable to send message='{}'", message, exc);
        }
      });

  }
}
