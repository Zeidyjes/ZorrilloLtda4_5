/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zorrillo.colonias.interfaces;

import com.zorrillo.colonias.modelo.Fragance;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Zeidy Johana Estupiñan S.
 */
public interface InterfaceFragance extends MongoRepository<Fragance, String>{
    public List<Fragance> findByPriceLessThanEqual(double precio);
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Fragance> findByDescriptionLike(String description);
}
