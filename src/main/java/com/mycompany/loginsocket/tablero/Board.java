/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket.tablero;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.mycompany.loginsocket.BoardForm;
import com.mycompany.loginsocket.Utils;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Usuario
 */
public class Board {

    public int[][] board;
    public LinkedHashMap<Integer, List<Pawn>> pawns = new LinkedHashMap<>();
    String template;

    public Board(String stringBoard, Graphics g) {
        this.template = stringBoard;
        Gson parser = new Gson();
        this.board = parser.fromJson(stringBoard, int[][].class);
        paint(g);
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template, Graphics g) {
        this.template = template;
        Gson parser = new Gson();
        this.board = parser.fromJson(template, int[][].class);
        paint(g);
    }

    public void paint(Graphics g) {
        int fil = 1;
        int col = 1;
        for (int[] data : board) {
            for (int i = 1; i <= data.length; i++) {
                String name = "";
                switch (data[i - 1]) {
                    case -1 ->
                        name = "base_yellow";
                    case -2 ->
                        name = "base_blue";
                    case -3 ->
                        name = "base_green";
                    case -4 ->
                        name = "base_red";
                    case -5 ->
                        name = "center";
                    case 0 ->
                        name = "rectangle_white";
                    case 1 ->
                        name = "rectangle_yellow";
                    case 11 ->
                        name = "star_yellow";
                    case 111 ->
                        name = "arrow_yellow";
                    case 1111 ->
                        name = "pawn_yellow";
                    case 2 ->
                        name = "rectangle_blue";
                    case 22 ->
                        name = "star_blue";
                    case 222 ->
                        name = "arrow_blue";
                    case 2222 ->
                        name = "pawn_blue";
                    case 3 ->
                        name = "rectangle_green";
                    case 33 ->
                        name = "star_green";
                    case 333 ->
                        name = "arrow_green";
                    case 3333 ->
                        name = "pawn_green";
                    case 4 ->
                        name = "rectangle_red";
                    case 44 ->
                        name = "star_red";
                    case 444 ->
                        name = "arrow_red";
                    case 4444 ->
                        name = "pawn_red";
                    case 10 ->
                        name = "star_white";
                }
                if (!name.isEmpty()) {
                    drawImage(50 + 30 * col, 150 + 30 * fil, g, name);
                }
                col++;
            }
            fil++;
            col = 1;
        }

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

    public void drawGamer(int number, int gamerId, Graphics g) {
        List<Pawn> pawns = this.pawns.get(gamerId);
        String name = "";
        switch (number) {
            case 1 -> 
                drawImage(50 + 30 * 1, 150 - 40, g, "profile_yellow");
            case 2 -> 
                drawImage(50 + 30 * 14, 150 - 40, g, "profile_blue");
            case 3 -> 
                drawImage(50 + 30 * 1, 150 + 30 * 16 + 10, g, "profile_green");
            case 4 -> 
                drawImage(50 + 30 * 14, 150 + 30 * 16 + 10, g, "profile_red");
        }
        for (Pawn p : pawns) {
            drawImage(50 + 30 * (p.y+1), 150 + 30 * (p.x+1), g, "pawn_"+p.color);
        }
    }

 

    public void repaint(Graphics g) {
        paint(g);
        int i = 1;
        for (Integer key : pawns.keySet()) {
            drawGamer(i, key, g);
            i++;
        }
    }

    public void addPawns(int clientId, List<Pawn> pawns) {
        this.pawns.put(clientId, pawns);
    }

    public void setPawns(LinkedHashMap<Integer, List<Pawn>> pawns) {
        this.pawns = pawns;
    }
      public List<Pawn> getPawnsById(int gamerId) {
        return pawns.get(gamerId);        
    }

}
