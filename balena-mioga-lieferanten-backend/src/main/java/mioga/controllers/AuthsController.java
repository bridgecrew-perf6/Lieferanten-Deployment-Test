package mioga.controllers;

import mioga.services.AuthsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import mioga.entites.Auths;


@RestController
@CrossOrigin
@RequestMapping("/auths")

public class AuthsController {

    final
    AuthsService authsService;

    public AuthsController(AuthsService authsService) {
        this.authsService = authsService;
    }

     @GetMapping
     ResponseEntity<Object> search(Auths auths, Pageable pageable) {
             return authsService.search(auths, pageable);
     }
     @PostMapping
     void create() {
     }
     @PutMapping
     void update(){
     }
     @DeleteMapping("/")
     void delete(){
     }
}
