/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

import com.mycompany.loginsocket.tablero.Board;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Game {
    LinkedList<Long> gamers = new LinkedList<>();
    Board board;
    long turn;

    public Game(String stringBoard, Graphics g) {
        board = new Board(stringBoard, g);
    }

    public Board getBoard() {
        return board;
    }
    public void setTurn(long turn){
        this.turn=turn;
    }
    public long getTurn(){
        return turn;
    }

    public void addGamer(long id) {
        gamers.add(id);
    }

    public void removeGamer(long id) {
        gamers.remove(id);
    }

}
