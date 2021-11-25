package me.itzg.app;

import java.time.Duration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app")
@Component
@Data
public class AppProperties {

  Duration generatorInterval = Duration.ofSeconds(60);
  int generatorBatchSize = 100;
  int fetchMaxBytes = 200;
}
