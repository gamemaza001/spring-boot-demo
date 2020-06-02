package com.springboot.demo.Controller;
import com.springboot.demo.Data.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonController {
    @GetMapping("/person")
    public ResponseEntity<?> getPerson () {
        Person person = new Person()
                .setAge(12)
                .setEmail("gamekub@gmail.com")
                .setName("game")
                .setNickName("Gamekub")
                .setTel("0818188216");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(person);
    }
}
