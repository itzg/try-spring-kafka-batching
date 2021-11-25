package me.itzg.app;

import java.time.Instant;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.Lifecycle;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

/**
 * Simulates some longer running config loading at startup prior to
 * the kafka consumer being ready.
 */
@Service
@Slf4j
public class AppConfigLoader {

  private final KafkaListenerEndpointRegistry registry;
  private final ThreadPoolTaskScheduler taskScheduler;

  public AppConfigLoader(KafkaListenerEndpointRegistry registry,
      ThreadPoolTaskScheduler taskScheduler) {
    this.registry = registry;
    this.taskScheduler = taskScheduler;
  }

  @EventListener
  public void init(ApplicationReadyEvent event) {
    log.info("Starting");
    taskScheduler.schedule(this::loaded, Instant.now().plusSeconds(10));
  }

  private void loaded() {
    log.info("Loaded...starting listener containers");
    registry.getAllListenerContainers().forEach(Lifecycle::start);
  }
}
