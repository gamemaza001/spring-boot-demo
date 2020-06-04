package com.springboot.demo.PersonRepository.mapper;

import com.springboot.demo.Data.Person;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getString("id"));
        person.setName(resultSet.getString("name"));
        person.setPhone(resultSet.getString("phone"));
        return person;
    }
}
