/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zorrillo.colonias.servicio;

import com.zorrillo.colonias.modelo.Order;
import com.zorrillo.colonias.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  * @author Zeidy Estupiñan
 * @Autowired atributo de relación
 */
@Service
public class UserOrder {
/**
 * @Autowired atributo de relación
 * Crear implementación de la interface
 */
    @Autowired
    private OrderRepositorio orderRepositorio;

    /**
     *
     * @return la lista de las ordenes
     */
    public List<Order> getAll() {
        return orderRepositorio.getAll();
    }

    /**
     *
     * @param id
     * @return optiene la orden por id
     */
    public Optional<Order> getOrder(int id) {
        return orderRepositorio.getOrder(id);
    }

    /**
     * Obtiene el maximo id existente en la coleccion, si el id de la orden
     * que se recibe como parametro es nulo, entonces valida el maximo id
     * existente en base de datos y valida el maximo id generado, si no hay
     * ninguno aun el primer id sera 1 entonces si retorna informacion suma 1 al maximo
     * id existente y lo asigna como el codigo de la orden
     *
     * @param order
     * @return la creación de la orden de la frangance
     */
    public Order create(Order order) {

        Optional<Order> orderIdMaxima = orderRepositorio.lastUserId();

        if (order.getId() == null) {

            if (orderIdMaxima.isEmpty()) {
                order.setId(1);
            } else {
                order.setId(orderIdMaxima.get().getId() + 1);
            }
        }

        Optional<Order> e = orderRepositorio.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepositorio.create(order);
        } else {
            return order;
        }
    }

    /**
     *
     * @param order
     * @return orden actualizada de la fragance
     */
    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepositorio.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepositorio.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    /**
     *
     * @param id
     * @return elimina la orden de la fragance devuelve vacio
     */
    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepositorio.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Ordenes de pedido asociadas a los asesores de una zona
     *
     * @param zona
     * @return la zona
     */
    public List<Order> findByZone(String zona) {
        return orderRepositorio.findByZone(zona);
    }

    /**
     * Ordenes de un asesor
     *
     * @param id
     * @return lista de las ordenes del asesor
     */
    public List<Order> ordersSalesManByID(int id) {
        return orderRepositorio.ordersSalesManByID(id);
    }

    /**
     * Ordenes de un asesor por fecha
     *
     * @param dateStr
     * @param id
     * @return la fecha de la orden
     */
    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return orderRepositorio.ordersSalesManByDate(dateStr, id);
    }

    /**
     * Ordenes de un asesor por estado
     *
     * @param state
     * @param id
     * @return el estado de la orden
     */
    public List<Order> ordersSalesManByState(String state, Integer id) {
        return orderRepositorio.ordersSalesManByState(state, id);
    }

}
