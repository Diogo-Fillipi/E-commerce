package intership.project.ecomerce.controller;

import intership.project.ecomerce.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return null;
    }


}
