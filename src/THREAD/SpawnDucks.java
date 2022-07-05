package THREAD;

import DUCKS.DuckGreen;
import DUCKS.DuckMain;
import DUCKS.DuckPink;
import DUCKS.DuckYellow;
import GAME.GameMechanic;
import GAME.Gun;
import GAME.Mode;

import javax.swing.*;

import static MAIN.Main.gameOver;

public class SpawnDucks extends Thread{
    public GameMechanic game;
    public Gun gun;
    boolean exit;
    public SpawnDucks(GameMechanic game ,Gun gun) {
        this.game=game;
        this.gun=gun;
    }

    public void run() {

        while (!exit) {
            if(gameOver){
                stopThread();
            }
            int time=0;
            try {
                game.add(Mode.getValue(),gun);
                game.addReverse(Mode.getValue(),gun);
                this.sleep(8000);
                DuckMain.setPointsIncrement();
                DuckGreen.setPointsIncrement();
                DuckPink.setPointsIncrement();
                DuckYellow.setPointsIncrement();
            } catch(InterruptedException exc) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");
                return;
            }


        }
    }
    public void stopThread()
    {
        exit = true;
    }
}
