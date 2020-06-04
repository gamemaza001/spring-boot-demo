package com.springboot.demo.Services;

import com.springboot.demo.Data.Person;
import com.springboot.demo.PersonRepository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person findById(String id){
        Person person = personRepository.findPersonById(id);
        return person;
    }

    public List findAll(){
        List termAndCondition = personRepository.findAll();
        return termAndCondition;
    }

    public Person createPerson(Person person){
        String id = personRepository.createPerson(person);
        return person;
    }

    public Object editPerson(Person person){
        return personRepository.editPerson(person);
    }

    public Object deletePerson(String Id) {
        String person = personRepository.deletePerson(Id);
        return person;
    }
}
