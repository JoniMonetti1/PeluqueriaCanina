package org.example.logic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numCliente;
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atencionEspecial;
    private String observaciones;
    
    @OneToOne
    private Duenio duenio;
}
