package com.springboot.demo.PersonRepository;


import com.springboot.demo.Data.Person;
import com.springboot.demo.PersonRepository.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.QueryCreationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class PersonRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Person findPersonById(String id){
        StringJoiner sql = new StringJoiner(" ")
                .add("SELECT id, name, phone")
                .add("FROM person")
                .add("WHERE id = :id;");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        return namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new PersonMapper()
        );
    }

    public List<Person> findAll(){
        StringJoiner sql = new StringJoiner(" ")
                .add("SELECT id, name, phone")
                .add("FROM person");
        return namedParameterJdbcTemplate.query(sql.toString(), new PersonMapper());
    }

    public String createPerson(Person person) {
        StringJoiner sql = new StringJoiner(" ");
        sql.add("INSERT INTO person(")
                .add("id, name, phone)")
                .add("VALUES (:id, :name, :phone);");

        HashMap<String, Object> params = new HashMap<>();
        params.put("id", person.getId());
        params.put("name", person.getName());
        params.put("phone", person.getPhone());
        try {
            namedParameterJdbcTemplate.update(sql.toString(), params);
            return person.getId();
        } catch (DataIntegrityViolationException ex) {
            return null;
        }

    }

    public Object editPerson(Person person) {
        StringJoiner sql = new StringJoiner(" ");
        sql.add("UPDATE person ")
                .add("SET name = :name, phone = :phone")
                .add("WHERE id = :id;");
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", person.getId());
        params.put("name", person.getName());
        params.put("phone", person.getPhone());
        try {
            return namedParameterJdbcTemplate.update(sql.toString(), params);
        } catch (Exception ex) {
            return null;
        }
    }

    public String deletePerson(String Id) {
        StringJoiner sql = new StringJoiner(" ");
        sql.add("DELETE FROM person ")
                .add("where id = :id");
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", Id);
        try {
            namedParameterJdbcTemplate.update(sql.toString(), params);
            return Id;
        } catch (QueryCreationException ex) {
            log.error("query error", ex.getMessage());
            return null;
        }
    }

}
