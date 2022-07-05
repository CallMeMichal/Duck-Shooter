package GAME;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class HighScores extends JFrame {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    public HighScores() throws IOException, ClassNotFoundException {
        generateFrame();
    }


        Vector<Person> w = new Vector<>();


        public void generateFrame() throws IOException, ClassNotFoundException {


            JList jlist = new JList(w);
            this.getContentPane().add(jlist);


            FileInputStream fi = new FileInputStream(new File("IMAGES\\plik1.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            Person pr1 = (Person) oi.readObject();
            pr1.toString();
            w.add(pr1);




            setSize(200,500);
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
}
