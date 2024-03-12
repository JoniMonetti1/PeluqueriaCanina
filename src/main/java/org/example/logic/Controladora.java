package org.example.logic;

import java.util.List;
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

    public List<Mascota> traerMascotas() {
        return controladoraPersistence.traerMascotas();
    }

    public void borrarMascota(int numCliente) {
        controladoraPersistence.borrarMascota(numCliente);
    }

    public Mascota traerMascota(int numCliente) {
        return controladoraPersistence.traerMascota(numCliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String raza, String color, String observaciones, String alergico, String atencionEsp, String duenio, String celDuenio) {
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAtencionEspecial(atencionEsp);
        mascota.setAlergico(alergico);
        
        //modificar mascota
        controladoraPersistence.modificarMascota(mascota);
        
        //seteo nuevos valores del dueño
        Duenio dueno = this.buscarDuenio(mascota.getDuenio().getIdDuenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(duenio);
        
        //llamar al modificar dueño
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controladoraPersistence.traerDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controladoraPersistence.modificarDuenio(dueno);
    }
}
