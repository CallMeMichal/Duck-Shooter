package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetLvl extends JFrame {

    JFrame frame = new JFrame();
    int mod;
    JButton easy = new JButton("Easy");
    JButton medium = new JButton("Medium");
    JButton hard = new JButton("Hardcore");

    public SetLvl() {

        this.setLayout(null);
        easy.setBounds(100, 80, 200, 40);
        medium.setBounds(100, 140, 200, 40);
        hard.setBounds(100, 200, 200, 40);

        easy.addActionListener(e -> {
            Mode.setValue(2);
            SwingUtilities.invokeLater(GameMechanic::new);
            this.dispose();
        });

        medium.addActionListener(e -> {
            Mode.setValue(4);
            SwingUtilities.invokeLater(GameMechanic::new);
            this.dispose();
        });

        hard.addActionListener(e -> {
            Mode.setValue(6);
            SwingUtilities.invokeLater(GameMechanic::new);
            this.dispose();
        });
        add(easy);
        add(hard);
        add(medium);
        setBackground(Color.YELLOW);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }


}
