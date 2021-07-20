/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.loginsocket;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Usuario
 */
public class BoardForm extends javax.swing.JFrame implements ResponseListener {

    /**
     * Creates new form BoardForm
     */
    ClientSocket clientSocket;
    String stringBoard;

    public BoardForm() {
        initComponents();
        // clientSocket = ClientSocket.getInstance(port, ip);
        //clientSocket.addListenner(this);
        stringBoard = "1,1,1,1,1,1,0,0,0,2,2,2,2,2,2,"
                + "1,0,0,0,0,1,0,2,2,2,0,0,0,0,2,"
                + "1,0,1,1,0,1,0,2,0,2,0,2,2,0,2,"
                + "1,0,1,1,0,1,0,2,0,2,0,2,2,0,2,"
                + "1,0,0,0,0,1,0,2,0,2,0,0,0,0,2,"
                + "1,1,1,1,1,1,0,2,0,2,2,2,2,2,2,"
                + "0,1,0,0,0,0,5,5,5,0,0,0,0,0,0,"
                + "0,1,1,1,1,1,5,5,5,4,4,4,4,4,4,"
                + "0,0,0,0,0,0,5,5,5,0,0,0,0,4,0,"
                + "3,3,3,3,3,3,0,0,0,4,4,4,4,4,4,"
                + "3,0,0,0,0,3,0,4,4,4,0,0,0,0,4,"
                + "3,0,3,3,0,3,0,4,0,4,0,4,4,0,4,"
                + "3,0,3,3,0,3,0,4,0,4,0,4,4,0,4,"
                + "3,0,0,0,0,3,0,4,0,4,0,0,0,0,4,"
                + "3,3,3,3,3,3,0,4,0,4,4,4,4,4,4";

    }

    public void paint(Graphics g) {
      /*      g.drawRect(50, 50, 450, 450);
        for (int i = 50; i <= 500; i += 30) {
            g.drawLine(i, 50, i, 500);
        }
        
        for (int i = 50; i <= 500; i += 30) {
            g.drawLine(50, i, 500, i);
        }
         */
      //g.fillRect(100 , 100, 100*2, 100*2);
        int fil = 1;
        int col = 1;
        String[] board = stringBoard.split(",");
        for (int i = 1; i <= board.length; i++) {                
            if (board[i - 1].compareTo("1") == 0) g.setColor(Color.yellow);
                
            if (board[i - 1].compareTo("2") == 0) g.setColor(Color.BLUE);
            if (board[i - 1].compareTo("3") == 0) g.setColor(Color.GREEN);
            if (board[i - 1].compareTo("4") == 0) g.setColor(Color.RED);
            if (board[i - 1].compareTo("0") == 0) g.setColor(Color.WHITE);
            
                            
            g.fillRect(50+30 * col,50+ 30 * fil, 30, 30);

            col++;
            if (i % 15 == 0) {
                fil++;
                col = 1;
            }
        }

        //g.fillRect(100 , 100, 400, 400);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardForm().setVisible(true);
            }
        });
    }

    @Override
    public void onResponse(ResponseEvent event) {

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}