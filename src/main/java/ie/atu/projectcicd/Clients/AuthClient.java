package ie.atu.projectcicd.Clients;

import ie.atu.projectcicd.Entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="auth-service", url = "http://localhost:8089")
public interface AuthClient {
    @PostMapping("/login")
    public String makeLogin(Person person);

    @PostMapping("/signup")
    public String makeSignUp(Person person);
}