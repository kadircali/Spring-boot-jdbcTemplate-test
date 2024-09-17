package org.kadir.test.repo;

import org.kadir.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Person person) {
        String sql = "insert into person  values (?, ?,?)";
       jdbcTemplate.update(sql,person.getName(),person.getLastName(),person.getAge());
    }

    public List<Person> findAll() {
      return   jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }
}
