/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class AuthController {
    DataInputStream in;
    DataOutputStream out;

    public AuthController(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }
       public String send(String data) throws IOException {
            out.writeUTF(data);
            String response = in.readUTF();
            System.out.println(response);
            return response;
    }
    
}
