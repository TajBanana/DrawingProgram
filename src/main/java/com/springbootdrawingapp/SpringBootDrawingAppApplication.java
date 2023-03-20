package com.springbootdrawingapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDrawingAppApplication implements CommandLineRunner {

  private final Program program;

  public SpringBootDrawingAppApplication(Program program) {
    this.program = program;
  }

  public static void main(String[] args) {
    System.out.println("Starting App...");
    SpringApplication.run(SpringBootDrawingAppApplication.class, args);
    System.out.println("Successfully Exited App...");
  }

  @Override
  public void run(String... args) {
    program.start();
  }
}
