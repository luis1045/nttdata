package com.proyecto1.person.apirest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String tipocuenta;
    private String descripcion;
    private int number;
    private BigDecimal Saldo;
}
