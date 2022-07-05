package DUCKS;

import javax.swing.*;

public class DuckYellow extends DuckMain {
    public  int points =5;

    public DuckYellow(JPanel panel) {
        super(panel);
    }

    @Override
    public void addDuckMain(int x, int y, JButton button) {
        super.addDuckMain(x, y, button);
    }

    @Override
    public int getPoints() {
        return points;
    }
}
