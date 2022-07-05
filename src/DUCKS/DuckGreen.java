package DUCKS;

import javax.swing.*;

public class DuckGreen extends DuckMain{
    public  int points = 4;

    public DuckGreen(JPanel panel) {
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
