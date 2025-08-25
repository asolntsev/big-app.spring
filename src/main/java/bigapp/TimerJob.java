package bigapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
class TimerJob {
  private static final Logger log = LoggerFactory.getLogger(TimerJob.class);

  @Scheduled(fixedDelay = 5000)
  public void logCurrentTime() {
    log.info("Time is {}", LocalDateTime.now());
  }
}
