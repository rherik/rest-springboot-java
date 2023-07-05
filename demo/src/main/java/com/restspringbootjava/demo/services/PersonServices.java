package com.restspringbootjava.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.restspringbootjava.demo.model.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    public List<Person> findAll() {
        logger.info("Finding all people!");

        List<Person> persons = new ArrayList<>();
        for (int index = 0; index < 8; index++) {
            Person person = mockPerson(index);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one person.");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Herik");
        person.setLastName("Cunha");
        person.setAddress("Rio de Janeiro");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person){
    logger.info("Creating one person.");

    return person;
}
    public Person update(Person person){
    logger.info("Updating one person.");

    return person;
}
    public void delete(String id){
        logger.info("Deleting one person.");
}

    private Person mockPerson(int index){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + index);
        person.setLastName("Last name " + index);
        person.setAddress("Some address in Brasil " + index);
        person.setGender("Male");
        return person;
    }

}
