package pl.pancordev.leak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringLeakApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringLeakApplication.class, args);
    }

}
