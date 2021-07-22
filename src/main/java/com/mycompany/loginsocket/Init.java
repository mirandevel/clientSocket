/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

/**
 *
 * @author Usuario
 */
public class Init {

    /**
     * @param args the command line arguments
     */
    public static ClientSocket clientSocket;
    public static void main(String[] args) {
        clientSocket = ClientSocket.getInstance(Integer.parseInt(args[0]), args[1]);
        new LoginForm().setVisible(true);
    }

    
}
