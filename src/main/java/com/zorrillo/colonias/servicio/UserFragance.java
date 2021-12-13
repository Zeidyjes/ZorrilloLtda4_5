/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zorrillo.colonias.servicio;

import com.zorrillo.colonias.modelo.Fragance;
import com.zorrillo.colonias.repositorio.FraganceRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zeidy Johana Estupiñan S.
 */
@Service
public class UserFragance {
     @Autowired
    private FraganceRepositorio fraganceRepositorio;
     
     
    public List<Fragance> getAll() {
        return fraganceRepositorio.getAll();
    }

   public Optional<Fragance> getFragance(String reference) {
        return fraganceRepositorio.getFragance(reference);
    }

    public Fragance create(Fragance fragance) {
        if (fragance.getReference() == null) {
            return fragance;
        } else {
            return fraganceRepositorio.create(fragance);
        }
    }

    public Fragance update(Fragance fragance) {

        if (fragance.getReference() != null) {
            Optional<Fragance> fraganceDb = fraganceRepositorio.getFragance(fragance.getReference());
            if (!fraganceDb.isEmpty()) {
                
                if (fragance.getBrand()!= null) {
                    fraganceDb.get().setBrand(fragance.getBrand());
                }
                
                if (fragance.getCategory() != null) {
                    fraganceDb.get().setCategory(fragance.getCategory());
                }
                 if (fragance.getPresentation() != null) {
                    fraganceDb.get().setPresentation(fragance.getPresentation());
                }
                                
                if (fragance.getDescription() != null) {
                    fraganceDb.get().setDescription(fragance.getDescription());
                }
                if (fragance.getPrice() != 0.0) {
                    fraganceDb.get().setPrice(fragance.getPrice());
                }
                if (fragance.getQuantity() != 0) {
                    fraganceDb.get().setQuantity(fragance.getQuantity());
                }
                if (fragance.getPhotography() != null) {
                    fraganceDb.get().setPhotography(fragance.getPhotography());
                }
                fraganceDb.get().setAvailability(fragance.isAvailability());
                fraganceRepositorio.update(fraganceDb.get());
                return fraganceDb.get();
            } else {
                return fragance;
            }
        } else {
            return fragance;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getFragance(reference).map(fragance -> {
            fraganceRepositorio.delete(fragance);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Reto 5
    public List<Fragance> gadgetsByPrice(double price) {
        return fraganceRepositorio.gadgetsByPrice(price);
    }

    //Reto 5
    public List<Fragance> findByDescriptionLike(String description) {
        return fraganceRepositorio.findByDescriptionLike(description);
    }
    

}
