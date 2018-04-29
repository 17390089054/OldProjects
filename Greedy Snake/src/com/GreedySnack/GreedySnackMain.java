package com.GreedySnack;

import javax.swing.JFrame;


public class GreedySnackMain extends JFrame {
    SnackWin snackwin;
    static final int Width = 800 , Height = 600 , LocX = 200 , LocY = 80;
    public GreedySnackMain() {
        super("GreedySncak_SL");
        snackwin = new SnackWin();
        add(snackwin);
        this.setSize(Width, Height);
        this.setVisible(true);
        this.setLocation(LocX, LocY);
        this.setDefaultCloseOperation(GreedySnackMain.EXIT_ON_CLOSE);
        snackwin.requestFocus();
    }
    public static void main(String[] args) {
        new GreedySnackMain();
    }
}
