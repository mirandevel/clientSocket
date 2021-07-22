/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ClientSocket extends Thread {
    private static ClientSocket INSTANCE = null;

    private Socket clientSocket;
    DataInputStream in;
    DataOutputStream out;
    LinkedList<ResponseListener> listeners=new LinkedList<>();
    
    private synchronized static void createInstance(int port, String ip) {
        if (INSTANCE == null) { 
            INSTANCE = new ClientSocket(port,ip);
        }
    }

    public static ClientSocket getInstance(int port, String ip) {
        if (INSTANCE == null) createInstance(port,ip);
        return INSTANCE;
    }
    

    public ClientSocket(int port, String ip) {
        try {
            clientSocket = new Socket(ip, port);
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   void addListenner(ResponseListener listener){
       listeners.add(listener);
   }
   void removeListenner(ResponseListener listener){
       listeners.remove(listener);
   }
   void notification(String response){
       for(ResponseListener listener:listeners){
           listener.onResponse(new ResponseEvent(this,response ));
       }
   }

    @Override
    public void run(){
     while(true){
         try {
             String response = in.readUTF();
             //System.out.println(response);
             notification(response);
         } catch (IOException ex) {
             Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
        
    }
    public void send(String message) throws IOException {
            out.writeUTF(message);
    }

}
