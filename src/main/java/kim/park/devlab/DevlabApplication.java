package kim.park.devlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DevlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevlabApplication.class, args);
    }

}
