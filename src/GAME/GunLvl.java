package GAME;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GunLvl {
    private static int value = 1;


    public static int getValue() {
        return value;
    }

    public static void increment(int x) {
        value = value + x;
    }

    public static void reset() {
        value = 0;
    }

    public static void setValue(int value) {
        GunLvl.value = value;
    }

    public static void check(Gun gun) {
        if ((GunLvl.getValue() == 1) && (Score.getValue() > 30)) {

            gun.setEnabled(true);

        }

        if ((GunLvl.getValue() == 2) && (Score.getValue() > 60)) {

            gun.setEnabled(true);

        }

        if ((GunLvl.getValue() == 3) && (Score.getValue() > 100)) {

            gun.setEnabled(true);


            if ((GunLvl.getValue() == 4) && (Score.getValue() > 140)) {

                gun.setEnabled(true);

            }
        }
    }
}
