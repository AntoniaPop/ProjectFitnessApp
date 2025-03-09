package ro.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation marks the class as the entry point for Spring Boot
public class App {

    public static void main(String[] args) {
        // This will start the Spring Boot application
        SpringApplication.run(App.class, args);
    }
}
