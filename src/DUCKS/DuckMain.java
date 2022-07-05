package DUCKS;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DuckMain extends JButton{
    AtomicInteger id = new AtomicInteger();
    int x,y;

    public static int points = 1;


    public int getPoints() {
        return points;
    }


    public DuckMain(JPanel panel) {
        panel.add(this);
    }

    public void addDuckMain(int x,int y,JButton button){

        id.incrementAndGet();
        button.setLocation(x,y);
        button.setSize(100,100);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
    }

    public void setX(int x) {
        this.x = x;
    }

    public static void setPointsIncrement(){
        points++;
    }
}
