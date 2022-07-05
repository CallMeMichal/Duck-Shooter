package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameStartFrame extends JFrame {


    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    ImageIcon icon = new ImageIcon("IMAGES\\image.png");
    JTextField text = new JTextField();
    public GameStartFrame() {


        setLayout(null);

        JButton btn = new JButton("New Game");
        JButton btn1 = new JButton("High Score");
        JButton btn2 = new JButton("Exit");


        btn.setBounds(300, 250, 200, 40);
        btn1.setBounds(300, 300, 200, 40);
        btn2.setBounds(300, 350, 200, 40);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() ==btn){
                    frame.dispose();
                    SwingUtilities.invokeLater(SetLvl::new);

                }
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() ==btn1){
                    frame.dispose();
                    SwingUtilities.invokeLater(() -> {
                        try {
                            new HighScores();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    });
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() ==btn2){

                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setVisible(false);
                    System.exit(0);
                }
            }
        });

        add(btn);
        add(btn1);
        add(btn2);



        JLabel label = new JLabel("",icon,JLabel.CENTER);
        label.setBounds(0,0,800,500);
        add(label);



        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Duck Shooter by Michal Tulej");

    }
}

