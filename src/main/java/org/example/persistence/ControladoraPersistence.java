package org.example.persistence;

import java.util.List;
import org.example.logic.Duenio;
import org.example.logic.Mascota;

public class ControladoraPersistence {
    
    DuenioJpaController duenioJpaController = new DuenioJpaController();
    MascotaJpaController mascotaJpaController = new MascotaJpaController();

    public void guardar(Duenio duenio1, Mascota mascota) {
        //Cremos en la BBDD el dueño 
        duenioJpaController.create(duenio1);
        
        //creamos en la BBDD la mascota
        mascotaJpaController.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        
        return mascotaJpaController.findMascotaEntities();
    }

    public void borrarMascota(int numCliente) {
        mascotaJpaController.eliminarMascotaPorId(numCliente);
    }
    
}
