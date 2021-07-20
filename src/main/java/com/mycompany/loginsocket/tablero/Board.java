/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket.tablero;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Board {
    Cell[][] matriz=new Cell[15][15];
    Map<Integer,Pawn[][]> Pawns=new HashMap<>();

    public Board() {
        //cargar Matriz
        //cargarPeones
    }

    public Cell[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Cell[][] matriz) {
        this.matriz = matriz;
    }

    public Map<Integer, Pawn[][]> getPawns() {
        return Pawns;
    }

    public void setPawns(Map<Integer, Pawn[][]> Pawns) {
        this.Pawns = Pawns;
    }
    
    
    
}
