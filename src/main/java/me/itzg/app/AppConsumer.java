package me.itzg.app;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppConsumer {

  @KafkaListener(topics = Application.TOPIC, autoStartup = "false",
      batch = "true",
      properties = {
          "fetch.max.bytes=#{appProperties.fetchMaxBytes}"
      })
  public void consume(List<String> contents) {
    log.info("Pretending to process contents={}", contents);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      log.warn("Interrupted", e);
    }
  }
}
