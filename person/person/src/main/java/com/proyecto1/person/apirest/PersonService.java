package com.proyecto1.person.apirest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonService {

    public Flux<Person> allPerson();
    public Mono<Person> addPerson(Person person);
    public Mono<Person> updatePerson(Person person);
    public Mono<Person> findPerson(String dni);
    public Mono<Void> deletePerson(String dni);
    public Mono<Person> checkAccount(String dni);
}
