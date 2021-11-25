package me.itzg.app;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessagesGenerator {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final AppProperties appProperties;

  private int messageId = 1;

  public MessagesGenerator(KafkaTemplate<String,String> kafkaTemplate,
      AppProperties appProperties) {
    this.kafkaTemplate = kafkaTemplate;
    this.appProperties = appProperties;
  }

  @Scheduled(fixedDelayString = "#{appProperties.generatorInterval}")
  public void send() {
    final int batchSize = appProperties.getGeneratorBatchSize();
    log.info("Generating messages {}..{}", messageId, messageId+ batchSize);
    for (int i = 0; i < batchSize; i++) {
      kafkaTemplate.send(Application.TOPIC,
          (messageId & 1) == 0 ? "even" : "odd",
          String.format("Message %d", messageId++));
    }
    log.info("Generated {} messages", batchSize);
  }
}
