/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zorrillo.colonias.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Zeidy Johana Estupiñan S. 
 */
@Document(collection = "perfumes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fragance {
    
@Id
private String reference;
private String brand;
private String category;
private String presentation;
private String description;
private boolean availability = true;
private double price;
private int quantity;
private String photography;

}
