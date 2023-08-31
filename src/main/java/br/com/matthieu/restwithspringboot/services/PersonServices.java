package br.com.matthieu.restwithspringboot.services;

import br.com.matthieu.restwithspringboot.models.Person;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {


    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("find all in person services");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }


    public Person findById(String id) {
        logger.info("find by id in person services");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Matthieu");
        person.setLastName("Christian");
        person.setAddress("Natal - RN - Brasil");
        person.setGender("MALE");

        return person;
    }

    public Person create(Person person) {
        logger.info("create in person services");
        return person;
    }

    public Person update(Person person) {
        logger.info("update in person services");
        return person;
    }

    public void delete(String id) {
        logger.info("delete in person services");
    }

    private Person mockPerson(int i) {

        Faker faker = new Faker(new Locale("pt-BR"));

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        person.setAddress(faker.address().fullAddress());
        person.setGender(faker.name().title());

        return person;
    }
}
