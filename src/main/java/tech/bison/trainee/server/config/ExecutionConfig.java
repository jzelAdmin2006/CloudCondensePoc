package tech.bison.trainee.server.config;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.concurrent.ExecutorService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutionConfig {

  @Bean
  ExecutorService archiving() {
    return newSingleThreadExecutor();
  }
}
