/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket.tablero;

import com.google.gson.Gson;
import com.mycompany.loginsocket.BoardForm;
import com.mycompany.loginsocket.Utils;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Usuario
 */
public class Board {
    
    int[] board;

    public Board(String stringBoard,Graphics g) {
        Gson parser = new Gson();
        int[] data = parser.fromJson(stringBoard, int[].class);
        this.board=data;
        paint(g);
    }
    public void paint(Graphics g) {
        if(board==null) return;
        int fil = 1;
        int col = 1;
        for (int i = 1; i <= board.length; i++) {
            String name = "";
            switch (board[i - 1]) {
                case -1:
                    name = "base_yellow";
                    break;
                case -2:
                    name = "base_blue";
                    break;
                case -3:
                    name = "base_green";
                    break;
                case -4:
                    name = "base_red";
                    break;
                case -5:
                    name = "center";
                    break;
                case 0:
                    name = "rectangle_white";
                    break;
                case 1:
                    name = "rectangle_yellow";
                    break;
                case 11:
                    name = "star_yellow";
                    break;
                case 111:
                    name = "arrow_yellow";
                    break;
                case 2:
                    name = "rectangle_blue";
                    break;
                case 22:
                    name = "star_blue";
                    break;
                case 222:
                    name = "arrow_blue";
                    break;
                case 3:
                    name = "rectangle_green";
                    break;
                case 33:
                    name = "star_green";
                    break;
                case 333:
                    name = "arrow_green";
                    break;
                case 4:
                    name = "rectangle_red";
                    break;
                case 44:
                    name = "star_red";
                    break;
                case 444:
                    name = "arrow_red";
                    break;
                case 10:
                    name = "star_white";
                    break;
            }
            if (!name.isEmpty()) {
                drawImage(50 + 30 * col, 150 + 30 * fil, g, name);
            }
            col++;
            if (i % 15 == 0) {
                fil++;
                col = 1;
            }
        }
        drawImage(50 + 30 * 14, 150 - 40, g, "profile");
        drawImage(50 + 30 * 1, 150 + 30 * 16 + 10, g, "profile");
    }
        void drawImage(int x, int y, Graphics g, String name) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(Utils.path + name + ".png"));
            g.drawImage(image, x, y, null);

        } catch (IOException ex) {
            Logger.getLogger(BoardForm.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    
    
    
    
}
