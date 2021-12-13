/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zorrillo.colonias.interfaces;

import com.zorrillo.colonias.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ydiez
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email,String password);

//Reto 5
    List<User> findByMonthBirthtDay(String monthBirthtDay);
    
    //Para seleccionar el usuario con el id maximo
    //Corresponde a esta consulta de mongodb: db.usuarios.find().limit(1).sort({$natural:-1})
    Optional<User> findTopByOrderByIdDesc();
}