package THREAD;
import DUCKS.DuckMain;
import javax.swing.*;

import static MAIN.Main.gameOver;

public class MovementR extends Thread{
    DuckMain duck;
    JProgressBar bar;
    int mode;
    public JButton button;
    public JPanel panel;
    boolean exit;
    public MovementR(JPanel panel, JButton button, DuckMain duck,JProgressBar bar,int mode) {
        this.panel=panel;
        this.button=button;
        this.duck=duck;
        this.bar=bar;
        this.mode = mode;
    }
    public MovementR(JPanel panel){
        this.panel=panel;
    }

    public void run() {

        while (!exit) {
            if(gameOver){
                stopThread();
            }
            try {
                this.sleep(20);
                duck.addDuckMain(duck.getX()+mode,duck.getY(),button);

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
