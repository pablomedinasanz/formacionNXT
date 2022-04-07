package com.example.ejercicioDependencias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ciudad {

    private String nombre;
    private int numeroHabitantes;
}
