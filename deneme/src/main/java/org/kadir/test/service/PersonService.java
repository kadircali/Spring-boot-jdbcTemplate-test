package org.kadir.test.service;

import org.kadir.test.model.Person;
import org.kadir.test.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
          this.personRepo = personRepo;
    }

    public void addStudent(Person person){

        if(person.getAge() >= 18 && person.getAge() <= 25) {
            personRepo.save(person);
        }else{
            System.out.println("invalid person");
        }

    }


    public List<Person> getAllStudents(){
        return personRepo.findAll();
    }

}
