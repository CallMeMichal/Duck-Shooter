package MAIN;

import GAME.GameStartFrame;
import THREAD.Timer;

import javax.swing.*;

public class Main {
    public static int Userlife=100;
    public static boolean gameOver;
    public static String nick;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameStartFrame::new);


    }



}
