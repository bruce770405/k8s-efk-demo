package tw.com.bruce.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringAppDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAppDemoApplication.class, args);
    }

}
