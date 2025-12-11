/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiReceta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
    @Autowired
    private Repositorio repo;

    public Receta grabar(Receta rec) {
        return repo.save(rec);
    }

    public Receta buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Receta> listar() {
        return repo.findAll();
    }

    public Receta actualizar(Long id, Receta rec) {
        return repo.findById(id).map(existing -> {
            existing.setFec(rec.getFec());
            existing.setHor(rec.getHor());
            existing.setIdAte(rec.getIdAte());
            existing.setIdMed(rec.getIdMed());
            existing.setTot(rec.getTot());
            return repo.save(existing);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
