/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baches.control;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author J_Die
 */
@Stateless
@LocalBean
public class BeanDePrueba implements Serializable{
    
    public final static String NOMBRE_USUARIO = "No disponible";
    
    public String getNombreUsuario(final Integer idUsuario){
        return NOMBRE_USUARIO;
    }
    
}
