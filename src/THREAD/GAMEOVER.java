package THREAD;
import GAME.GameStartFrame;
import GAME.HighScores;
import GAME.Player;
import GAME.Score;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static MAIN.Main.gameOver;
import static MAIN.Main.Userlife;
import static MAIN.Main.nick;
public class GAMEOVER extends Thread{

    boolean exit;
    JFrame frame ;
    public GAMEOVER(JFrame frame){
        this.frame=frame;
    }

    public void run() {

        while (!exit) {
            try {
                this.sleep(100);
              if(Userlife<=0){
                  JFrame frame = new JFrame();
                  frame.setBounds(200,200,500,500);
                  gameOver = true;
                  var finishScore = Score.getValue();
                  exit=true;
                   nick =JOptionPane.showInputDialog(null,"Type Nick");
                  System.out.println("Twoj nick to " + nick);
                  Player p = new Player();
                  this.frame.dispose();

              }

            } catch(InterruptedException exc) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }




    }






    public void stopThread()
    {
        exit = false;
    }
}
