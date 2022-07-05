package THREAD;

import GAME.Score;
import OBSTACLES.Cloud;
import OBSTACLES.Tree;

import javax.swing.*;

import static MAIN.Main.gameOver;


public class CloudMov extends  Thread{

    Cloud cloud;
    public JButton button;
    public JPanel panel;
    boolean exit;
    int change =1;
    public CloudMov(Cloud cloud, JButton button, JPanel panel) {
        this.cloud=cloud;
        this.button = button;
        this.panel = panel;
    }

    public void run() {

        while (!exit) {
            if(gameOver){
                stopThread();
            }

            try {
                this.sleep(5);

                if(cloud.getX() > 1200 ){
                    change=-1;
                }

                if(cloud.getX() < 50 ){
                    change=1;
                }

                cloud.addCloud((int) (cloud.getX()+change),cloud.getY(),button);

            } catch(Exception x) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");

            }

        }

    }

    public void stopThread()
    {
        exit = true;
    }
}
