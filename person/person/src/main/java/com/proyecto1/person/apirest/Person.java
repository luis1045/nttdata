package com.proyecto1.person.apirest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Person")
public class Person {
    @Id
    private String dni;
    private String firstname;
    private String lastname;
    private String email;
    private List<Account> accounts;
    private List<Credit> credits;
}
