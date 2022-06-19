package edu.utel.demojdbc.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Empleado {

    private final int id;
    private String nombre;
    private String apellidos;
    private String email;
    private float salario;
    private int departamento;

}
