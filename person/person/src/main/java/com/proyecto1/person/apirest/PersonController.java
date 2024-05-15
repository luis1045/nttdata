package com.proyecto1.person.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
   // @Autowired
    //private PersonSericeImpl personSericeImpl;

    @Autowired
    private PersonService PersonService;
    @GetMapping("/allperson")
    public ResponseEntity<Flux<Person>> allPerson(){
        Flux<Person> response=this.PersonService.allPerson();
        return new ResponseEntity<Flux<Person>>(response, HttpStatus.OK);
    }

    @PostMapping("/addperson")
    public  ResponseEntity<Mono<Person>> addPerson(@RequestBody Person person){

        Mono<Person> response = this.PersonService.addPerson(person);
        return new ResponseEntity<Mono<Person>>(response, HttpStatus.OK);
    }
    @PutMapping("/updateperson")
    public  ResponseEntity<Mono<Person>> updatePerson(@RequestBody Person person){

        Mono<Person> response = this.PersonService.addPerson(person);
        return new ResponseEntity<Mono<Person>>(response, HttpStatus.OK);
    }

    @GetMapping("/findperson/{id}")
    public ResponseEntity<Mono<Person>> findPerson( @PathVariable String id){
        Mono<Person> response=this.PersonService.findPerson(id);
        return new ResponseEntity<Mono<Person>>(response, HttpStatus.OK);
    }
    @DeleteMapping("/deleteperson")
    public  ResponseEntity<Mono<Void>> deletePerson(@PathVariable String id){
        Mono<Void> response = this.PersonService.deletePerson(id);
        return new ResponseEntity<Mono<Void>>(response, HttpStatus.OK);
    }

    @GetMapping("/checkaccount/{id}")
    public ResponseEntity<Mono<Person>> checkAccount(@PathVariable String id){
        //Flux<Account> response = this.personSericeImpl.checkAccount(id).blockOptional().stream().map(s->s.getAccounts()).collect(toli);
        Mono<Person> response = this.PersonService.checkAccount(id);
        return new ResponseEntity<Mono<Person>>(response, HttpStatus.OK);
    }


}
