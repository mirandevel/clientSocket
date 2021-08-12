/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket.controllers;

import com.google.gson.Gson;
import com.mycompany.loginsocket.ClientSocket;
import com.mycompany.loginsocket.Utils;
import com.mycompany.loginsocket.models.Response;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.json.simple.JSONObject;

/**
 *
 * @author Usuario
 */
public class DiceController {

    JButton dice;
    ClientSocket clientSocket;
     Gson gson = new Gson();

    public DiceController(JButton dice, ClientSocket clientSocket) {
        this.dice = dice;
        this.clientSocket = clientSocket;
    }

    public void launch() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int i = 0;

            public void run() {
                Random r = new Random();
                int rand = r.nextInt(6) + 1;
                i++;
                if (i == 10) {
                    send(rand,Response.FINISH_DICE);
                    timer.cancel();
                    
                }else{
                    send(rand,Response.LAUNCH_DICE);
                }
            }
        };
        timer.schedule(timerTask, 50, 100);
    }
    

    void send(int rand,String action) {
        try {
            Response response=new Response(action);
            response.add("number", rand);
            clientSocket.send(gson.toJson(response));
        } catch (IOException ex) {
            Logger.getLogger(DiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
