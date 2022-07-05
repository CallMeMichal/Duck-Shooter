package GAME;

import THREAD.GunCheck;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gun extends JButton {
    boolean buttonvisible;

  public Gun(JPanel panel){
      panel.add(this);

    }


    public void addGun(JButton button){


        button.setBounds(1100,0,200,100);
        button.setText("Upgrade your Gun!");
        button.setVisible(true);
        button.setEnabled(false);

    }




}
