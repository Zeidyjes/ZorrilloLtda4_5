/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zorrillo.colonias.repositorio;

import com.zorrillo.colonias.interfaces.InterfaceFragance;
import com.zorrillo.colonias.modelo.Fragance;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ydiez
 */
@Repository
public class FraganceRepositorio {
    @Autowired
    private InterfaceFragance interfaceFragance;

    public List<Fragance> getAll() {
        return interfaceFragance.findAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return interfaceFragance.findById(reference);
    }
    public Fragance create(Fragance fragance) {
        return interfaceFragance.save(fragance);
    }

    public void update(Fragance fragance) {
        interfaceFragance.save(fragance);
    }
    
    public void delete(Fragance fragance) {
        interfaceFragance.delete(fragance);
    }
    //Reto 5
    public List<Fragance> gadgetsByPrice(double precio) {
        return interfaceFragance.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Fragance> findByDescriptionLike(String description) {
        return interfaceFragance.findByDescriptionLike(description);
    }


}
