/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zorrillo.colonias.repositorio;

import com.zorrillo.colonias.interfaces.InterfaceUser;
import com.zorrillo.colonias.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zeidy Johana Estupiñan S.
 */
@Repository
public class UserRepositorio {

    @Autowired
    private InterfaceUser interfaceUser;

    public List<User> getAll() {
        return (List<User>) interfaceUser.findAll();
    }

    public Optional<User> getUser(int id) {
        return interfaceUser.findById(id);
    }

    public User create(User user) {
        return interfaceUser.save(user);
    }

    public void update(User user) {
        interfaceUser.save(user);
    }

    public void delete(User user) {
        interfaceUser.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = interfaceUser.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return interfaceUser.findByEmailAndPassword(email, password);
    }

    public Optional<User> lastUserId() {
        return interfaceUser.findTopByOrderByIdDesc();
    }
    public List<User> birthtDayList(String monthBirthtDay) {
        return interfaceUser.findByMonthBirthtDay(monthBirthtDay);
    }

}
