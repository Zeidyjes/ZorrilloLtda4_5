/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zorrillo.colonias.servicio;

import com.zorrillo.colonias.modelo.User;
import com.zorrillo.colonias.repositorio.UserRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ydiez
 */
@Service
public class UserService {
    @Autowired
    private UserRepositorio userRepositorio;

    public List<User> getAll() {
        return userRepositorio.getAll();
    }

    public Optional<User> getUser(int id) {
        
        return userRepositorio.getUser(id);
    }

    public User create(User user) {
        
        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepositorio.lastUserId();
        
        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty())
                user.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        
        Optional<User> e = userRepositorio.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return userRepositorio.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
        
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public boolean emailExists(String email) {
        return userRepositorio.emailExists(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepositorio.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepositorio.birthtDayList(monthBirthtDay);
    }
}
