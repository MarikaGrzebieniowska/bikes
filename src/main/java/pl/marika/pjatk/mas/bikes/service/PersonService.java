package pl.marika.pjatk.mas.bikes.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import pl.marika.pjatk.mas.bikes.model.Person;
import pl.marika.pjatk.mas.bikes.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void saveAll(Collection<Person> persons) {
        personRepository.saveAll(persons);
    }
}
