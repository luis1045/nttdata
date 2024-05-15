package com.proyecto1.person.apirest;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends ReactiveMongoRepository<Person,String> {
}
