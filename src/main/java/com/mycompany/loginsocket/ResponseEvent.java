/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

import java.util.EventObject;

/**
 *
 * @author Usuario
 */
public class ResponseEvent extends EventObject{
    String response;
    public ResponseEvent(Object source,String response) {
        super(source);
        this.response=response;
    }

    public String getResponse() {
        return response;
    }
    
    
    
}
