package THREAD;

import OBSTACLES.Cloud;
import OBSTACLES.Tree;

import javax.swing.*;

import static MAIN.Main.gameOver;

public class TreeMov extends  Thread{

    Tree tree;
    public JButton button;
    public JPanel panel;
    int speed =1;
    boolean exit;
    public TreeMov(Tree tree, JButton button, JPanel panel) {
        this.tree=tree;
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

                if(tree.getX() == 1200 ){
                    speed=-2;
                }

                if(tree.getX() == 50 ){
                    speed=2;
                }

                tree.addTree(tree.getX()+speed,tree.getY(),button);

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
