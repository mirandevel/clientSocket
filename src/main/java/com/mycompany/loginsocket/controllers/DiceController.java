/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket.controllers;

import com.mycompany.loginsocket.ClientSocket;
import com.mycompany.loginsocket.Utils;
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
                    send(rand,"finish_dice");
                    timer.cancel();
                    
                }else{
                    send(rand,"launch_dice");
                }
            }
        };
        timer.schedule(timerTask, 50, 100);
    }
    

    void send(int rand,String action) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("action", action);
            obj.put("number", rand);
            clientSocket.send(obj.toJSONString());
        } catch (IOException ex) {
            Logger.getLogger(DiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
