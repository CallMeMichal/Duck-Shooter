package THREAD;

import DUCKS.DuckMain;
import GAME.Gun;
import GAME.Score;

import javax.swing.*;

import static MAIN.Main.gameOver;

public class GunCheck extends Thread{

    Gun gun;
    public JButton button;
    public JPanel panel;
    boolean exit;
    public GunCheck(JPanel panel, JButton button, Gun gun){
        this.panel=panel;
        this.button=button;
        this.gun=gun;

    }

    public void run() {

        while (!exit) {
            if(gameOver){
                stopThread();
            }
            try {
                this.sleep(1000);
                //gun.addGun(gun);
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
