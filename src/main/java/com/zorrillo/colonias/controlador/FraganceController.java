/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zorrillo.colonias.controlador;


import com.zorrillo.colonias.modelo.Fragance;
import com.zorrillo.colonias.servicio.UserFragance;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zeidy Johana Estupiñan S.
 */
@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FraganceController {

    @Autowired
    private UserFragance userFragance;

    @GetMapping("/all")
    public List<Fragance> getAll() {
        return userFragance.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Fragance> getFragance(@PathVariable("reference") String reference) {
        return userFragance.getFragance(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance create(@RequestBody Fragance fragance) {
        return userFragance.create(fragance);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance fragance) {
        return userFragance.update(fragance);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return userFragance.delete(reference);
    }
    
     @GetMapping("/price/{price}")
    public List<Fragance> gadgetsByPrice(@PathVariable("price") double precio) {
        return userFragance.gadgetsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Fragance> findByDescriptionLike(@PathVariable("description") String description) {
        return userFragance.findByDescriptionLike(description);
    }

}
