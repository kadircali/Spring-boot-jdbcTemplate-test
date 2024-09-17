package org.kadir.test;

import org.kadir.test.model.Person;
import org.kadir.test.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DenemeApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(DenemeApplication.class, args);


		//person nesnesi
		Person person = new Person();
		person.setName("Seda");
		person.setLastName("sürmeli");
		person.setAge(24);


		//service
		PersonService service =  context.getBean(PersonService.class);
		//add person
		//service.addStudent(person);


		//list person
		List<Person> persons =  service.getAllStudents();
	for (Person person1 : persons) {
		System.out.println(person1.getName());
	}


	}

}
