package com.springboot.demo.Controller;
import com.springboot.demo.Data.Person;
import com.springboot.demo.Data.response.ResponseModel;
import com.springboot.demo.Services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person/{id}")
    public ResponseEntity<?> personById(@PathVariable String id) {
        Person person = personService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseModel(person));
    }

    @GetMapping("/person")
    public ResponseEntity<?> personAll() {
        List personServiceAll = personService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseModel(personServiceAll));
    }

    @PostMapping("/person")
    public ResponseEntity<?> create(@RequestBody Person person) {
        Person person1 = personService.createPerson(person);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseModel(person1));
    }

    @PutMapping("/person")
    public ResponseEntity<ResponseModel> editProfile(@RequestBody Person person) {
        Object person1 = personService.editPerson(person);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseModel(person1));
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable String id) {
        Object person = personService.deletePerson(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseModel(person));
    }
}
