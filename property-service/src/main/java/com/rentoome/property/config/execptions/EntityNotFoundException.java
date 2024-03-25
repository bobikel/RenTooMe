/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.config.execptions;

/**
 *
 * @author manbi
 */
public class EntityNotFoundException extends RuntimeException {

    static final long serialVersionUID = -7034897190745766939L;

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

}
