package com.example.rediscrud.dao;

import com.example.rediscrud.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.rediscrud.domain.Gender.FEMALE;
import static com.example.rediscrud.domain.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSaveAndFindAll() {

        List<Person> persons = createPersonList();

        persons.forEach(person -> personRepository.save(person));

        List<Person> foundPersons = new ArrayList<>();
        personRepository.findAll().forEach(foundPersons::add);

        assertThat(foundPersons).size().isEqualTo(3);

    }

    @Test
    public void testSaveAndFindById() {

        List<Person> persons = createPersonList();

        persons.forEach(person -> personRepository.save(person));

        Person person = personRepository.findById("id2").get();

        assertThat(person).isEqualTo(persons.get(1));

    }

    @Test
    public void testSaveAndFindByJobId() {

        List<Person> persons = createPersonList();

        UUID uuid = UUID.randomUUID();
        persons.get(1).setJobId(uuid);

        persons.forEach(person -> personRepository.save(person));

        List<Person> foundPersons = new ArrayList<>();
        personRepository.findByJobId(uuid).forEach(foundPersons::add);

        assertThat(foundPersons).size().isEqualTo(1);
        assertThat(foundPersons.get(0)).isEqualTo(persons.get(1));

    }

    private List<Person> createPersonList() {

        return List.of(
                new Person("id1", "John", "Doe", MALE, UUID.randomUUID()),
                new Person("id2", "Emilie", "Forsberg", FEMALE, UUID.randomUUID()),
                new Person("id3", "Anna", "Fenninger", FEMALE, UUID.randomUUID())
        );

    }


}
