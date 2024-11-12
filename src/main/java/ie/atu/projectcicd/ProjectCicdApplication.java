package ie.atu.projectcicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjectCicdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectCicdApplication.class, args);
    }

}
