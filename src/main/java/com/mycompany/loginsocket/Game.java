/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

import com.mycompany.loginsocket.tablero.Board;
import com.mycompany.loginsocket.tablero.Gamer;
import com.mycompany.loginsocket.tablero.Pawn;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Game {

    HashMap<Integer, Gamer> gamers = new HashMap<>();
    Board board;
    int turnId;

    public Game(String stringBoard, Graphics g) {
        board = new Board(stringBoard, g);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setTurn(int turnId) {
        this.turnId = turnId;
    }

    public int getTurn() {
        return turnId;
    }

    public void addGamer(Gamer gamer,List<Pawn> pawns) {
        
        gamers.put(gamer.getClientHash(), gamer);
        board.addPawns(gamer.getClientHash(),pawns);
    }

    public void removeGamer(Gamer gamer) {
        gamers.remove(gamer.getClientHash());
    }

    void setPawns(LinkedHashMap<Integer, List<Pawn>> pawns) {
        board.setPawns(pawns);
    }

}
