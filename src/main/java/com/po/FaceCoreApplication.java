package com.po;

import java.io.Serializable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.po"})
public class FaceCoreApplication implements Serializable {

  public static void main(String[] args) {
    SpringApplication.run(FaceCoreApplication.class, args);
  }

}
