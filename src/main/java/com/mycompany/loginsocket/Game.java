/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

import com.google.gson.Gson;
import com.mycompany.loginsocket.models.Response;
import com.mycompany.loginsocket.tablero.Board;
import com.mycompany.loginsocket.tablero.Gamer;
import com.mycompany.loginsocket.tablero.Pawn;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
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

    public void addGamer(Gamer gamer, List<Pawn> pawns) {

        gamers.put(gamer.getClientHash(), gamer);
        board.addPawns(gamer.getClientHash(), pawns);
    }

    public void removeGamer(Gamer gamer) {
        gamers.remove(gamer.getClientHash());
    }

    void setPawns(LinkedHashMap<Integer, List<Pawn>> pawns) {
        board.setPawns(pawns);
    }

    boolean allPawnsInBase() {

        for (Pawn p : board.pawns.get(LoginForm.clientHash)) {
             if(!p.inBase()){
                 return false;
             }
        }
        return true;
    }

    void movePawn(Pawn pawn,int number) throws IOException {
        Pawn p = new Pawn(pawn.x, pawn.y, pawn.id, pawn.color);
        int i = 1;
        for (Integer key : board.pawns.keySet()) {
            if (key == LoginForm.clientHash) {
                break;
            }
            i++;
        }
        boolean inBase=false;
        if (p.inBase()) {
            inBase=true;
            switch (i) {
                case 1 -> {
                    p.x = 6;
                    p.y = 2;
                    p.anterior=new Point(6,0);
                }
                case 2 -> {
                    p.x = 2;
                    p.y = 8;
                    p.anterior=new Point(0,8);
                }
                case 3 -> {
                    p.x = 13;
                    p.y = 6;
                    p.anterior=new Point(14,6);
                }
                case 4 -> {
                    p.x = 8;
                    p.y = 13;
                    p.anterior=new Point(8,14);
                }
            }
        } else {
            while(number>0){
               moveOne(p, number);
               number--;
            }
        }
        Gson gson = new Gson();
        Response response = new Response(Response.MOVE_PAWN);
        response.add("pawn", gson.toJson(p));
        response.add("id", LoginForm.clientHash);
        response.add("in_base", inBase);
        Init.clientSocket.send(gson.toJson(response));

    }

    void updatePawn(int id, Pawn pawn, Graphics g) {
        for (Pawn p : board.getPawnsById(id)) {
            if (p.id == pawn.id) {
                p.x = pawn.x;
                p.y = pawn.y;
            }
        }
        board.repaint(g);
    }

    void moveOne(Pawn p,int number ){        
            if(validPostition(p.x-1,p.y, p.anterior)) {
                p.anterior=new Point(p.x,p.y);
                p.x=p.x-1; 
                return;
            }
            if(validPostition(p.x+1,p.y, p.anterior)) {
                p.anterior=new Point(p.x,p.y);
                p.x=p.x+1; 
                return;
            }
            
            if(validPostition(p.x,p.y-1, p.anterior)) {
                p.anterior=new Point(p.x,p.y);
                p.y=p.y-1; 
                return;
            }
            if(validPostition(p.x,p.y+1, p.anterior)) {
                p.anterior=new Point(p.x,p.y);
                p.y=p.y+1; 
                return;
            }
            
            if(validPostition(p.x+1,p.y+1, p.anterior)){
                p.anterior=new Point(p.x,p.y);
                p.y=p.y+1;
                p.x=p.x+1;
                return;
            }
            
            if(validPostition(p.x-1,p.y-1, p.anterior)){
                p.anterior=new Point(p.x,p.y);
                p.y=p.y-1;
                p.x=p.x-1;
                return;
            }
            
            if(validPostition(p.x-1,p.y+1, p.anterior)){
                p.anterior=new Point(p.x,p.y);
                p.y=p.y+1;
                p.x=p.x-1;
                return;
            }
            
             if(validPostition(p.x+1,p.y-1, p.anterior)){
                 p.anterior=new Point(p.x,p.y);
                p.y=p.y-1;
                p.x=p.x+1;
                return;
            }   
    }
    boolean validPostition(int x,int y,Point anterior){
        
        if(x==anterior.x && y==anterior.y) return false;
        if(x<0 || x>14 || y<0 || y>14) return false;
        
        
        if(this.board.board[x][y]==0) return true;
        if(this.board.board[x][y]==10) return true;
        
        if(this.board.board[x][y]==11) return true;
        if(this.board.board[x][y]==111) return true;
        
        if(this.board.board[x][y]==22) return true;
        if(this.board.board[x][y]==222) return true;
        
        if(this.board.board[x][y]==33) return true;
        if(this.board.board[x][y]==333) return true;
        
        if(this.board.board[x][y]==44) return true;
        if(this.board.board[x][y]==444) return true;
        
        return false;
        
    }
    
}
