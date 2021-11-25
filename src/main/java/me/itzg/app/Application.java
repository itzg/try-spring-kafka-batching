package me.itzg.app;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

  protected static final String TOPIC = "messages";

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  NewTopic messagesTopic() {
    return TopicBuilder.name(TOPIC)
        .partitions(2)
        .build();
  }
}
