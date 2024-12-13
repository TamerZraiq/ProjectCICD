package ie.atu.projectcicd.Controller;

import ie.atu.projectcicd.Entity.Person;
import ie.atu.projectcicd.Clients.AuthClient;
import ie.atu.projectcicd.Service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {
    private final PersonService personService;
    private final AuthClient authClient;

    public PersonController(PersonService personService, AuthClient authClient) {
        this.personService = personService;
        this.authClient = authClient;
    }


    @GetMapping("/login/{userId}")
    public ResponseEntity<?> getPerson(@PathVariable String userId) {
        if (userId.length() > 5 || userId.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }

        Person person = personService.getPersonByUserId(userId);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        String details = authClient.makeLogin(person);
        System.out.println(details);

        return ResponseEntity.ok(person);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> getSignUp(@RequestBody Person person) {
        if (person.getUserId().length() > 5 || person.getUserId().isBlank()) {
            return ResponseEntity.badRequest().body("UserId is invalid");
        }

        Person existPerson = personService.getPersonByUserId(person.getUserId());
        if (existPerson == null) {
            return ResponseEntity.notFound().build();
        }
        String details = authClient.makeSignUp(person);
        System.out.println(details);

        return ResponseEntity.ok(person);
    }
}
