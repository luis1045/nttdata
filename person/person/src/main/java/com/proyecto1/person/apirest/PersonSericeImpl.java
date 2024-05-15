package com.proyecto1.person.apirest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class PersonSericeImpl implements  PersonService {
    @Autowired
    private PersonRepo repo;

    @Override
    public Flux<Person> allPerson(){
        return this.repo.findAll();
    }

    @Override
    public Mono<Person> addPerson(Person person){
        Long numCA = person.getAccounts().stream().filter(s->s.getTipocuenta().equals("1")).count();
        Long numCC = person.getAccounts().stream().filter(s->s.getTipocuenta().equals("2")).count();

        log.error("el numero de cuentas corientes es:"+numCC);
        if((numCA<2L && numCC<2L)){
            return this.repo.save(person);
            //Mono<Person> personMono = Mono.just(person);
            //return personMono;

        }else{
            return Mono.error(new IllegalArgumentException("El Usuario no puede tener más de una cuenta corrinte "));
        }

    }
    @Override
    public Mono<Person> updatePerson(Person person){
        Long numCA = person.getAccounts().stream().filter(s->s.getTipocuenta().equals("1")).count();
        Long numCC = person.getAccounts().stream().filter(s->s.getTipocuenta().equals("2")).count();

        log.error("el numero de cuentas corientes es:"+numCC);
        if((numCA<2L && numCC<2L)){
            return this.repo.save(person);


        }else{
            return Mono.error(new IllegalArgumentException("El Usuario no puede tener más de una cuenta corrinte "));
        }
    }
    @Override
    public Mono<Person> findPerson(String dni){
        return this.repo.findById(dni);
    }
    @Override
    public Mono<Void> deletePerson(String dni){
        return this.repo.deleteById(dni);
    }

    @Override
    public Mono<Person> checkAccount(String dni) {


        return this.repo.findById(dni);
    }
}
