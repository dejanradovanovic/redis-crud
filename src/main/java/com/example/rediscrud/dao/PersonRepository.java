package com.example.rediscrud.dao;

import com.example.rediscrud.domain.Gender;
import com.example.rediscrud.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, String> {

    Iterable<Person> findAllByGender(Gender gender);
    Iterable<Person> findByJobId(UUID jobId);

}
