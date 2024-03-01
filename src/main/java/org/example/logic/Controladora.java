package org.example.logic;

import org.example.persistence.ControladoraPersistence;

public class Controladora {
    ControladoraPersistence controladoraPersistence = new ControladoraPersistence();

    public void guardar(String nombreMascota, String raza, String color, String observaciones, String duenio, String celDuenio, String alergico, String atencionEsp) {
        
        //Creamos el dueño y asignamos valores a sus atributos
        Duenio duenio1 = new Duenio();
        duenio1.setNombre(duenio);
        duenio1.setCelDuenio(celDuenio);
        
        
        //Creamos la mascota y asignamos valores a sus atributos
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEsp);
        mascota.setDuenio(duenio1);
        
        //Usamos la controladora de la persistencia para guardar los datos en Base de datos
        controladoraPersistence.guardar(duenio1, mascota);
        
    }
}
