/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket.controllers;

import com.mycompany.loginsocket.Utils;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class DiceController {
    JButton dice;

    public DiceController(JButton dice) {
        this.dice=dice;
    }
    public void launch(){
                Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int i = 0;

            public void run() {
                Random r = new Random();
                int rand = r.nextInt(6) + 1;
                Icon icon = new ImageIcon(Utils.path + "dice_" + rand + ".png");
                dice.setIcon(icon);
                System.out.println(rand);
                i++;
                if (i == 10) {
                    timer.cancel();

                }
            }
        };
        timer.schedule(timerTask, 50, 100);
    }
    
}
