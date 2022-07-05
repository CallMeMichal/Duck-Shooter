package DUCKS;

import javax.swing.*;

public class DuckPink extends DuckMain{
    public int points =3;


    public DuckPink(JPanel panel) {
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
