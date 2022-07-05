package OBSTACLES;

import javax.swing.*;

public class Cloud extends JButton {
    int x,y;


    public Cloud(JPanel panel) {
        panel.add(this);
    }

    public void addCloud(int x,int y,JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setLocation(x,y);
        button.setSize(100,100);
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setIcon(new ImageIcon("IMAGES\\cloud.png"));
    }

    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }
}
