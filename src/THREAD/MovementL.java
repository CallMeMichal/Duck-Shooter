package THREAD;
import DUCKS.DuckMain;
import GAME.GameMechanic;
import javax.swing.*;

import static MAIN.Main.gameOver;

public class MovementL extends Thread {
    DuckMain duck;
    int mode;

    GameMechanic game;
    public JButton button;
    public JPanel panel;
    boolean exit;
    public MovementL(JPanel panel, JButton button, DuckMain duck,int mode) {
        this.panel=panel;
        this.button=button;
        this.duck=duck;
        this.mode=mode;

    }

//    public MovementL(JPanel panel){
//    this.panel=panel;
//    }


    public void run() {

        while (!exit) {
            if(gameOver){
                stopThread();

            }
            try {
                this.sleep(10);
                duck.addDuckMain(duck.getX()-mode,duck.getY(),button);
                if(duck.getX() < 0){
                    button.remove(duck);
                }

            } catch(InterruptedException exc) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");

            }

        }

    }
    public void stopThread()
    {
        exit = true;
    }
}
