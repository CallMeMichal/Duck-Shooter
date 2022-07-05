package THREAD;

import GAME.Score;

import javax.swing.*;

import static MAIN.Main.gameOver;


public class Timer extends Thread {
    public  JLabel t;
    boolean exit;

    public Timer(JLabel t) {
        this.t = t;
    }

    public void run() {

        double current = 0.0;
        while (!exit) {
            if(gameOver){
                stopThread();
            }
            try {
                this.sleep(10);

                current +=0.01;
                var z = round(current, 2);
                t.setText("Time:" + z);
                var wynik = z*(current/2);
                var zz=round(wynik,2);
                //Score.setValue((int)zz);

            } catch(InterruptedException exc) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");

            }

        }
    }

    // metoda z  https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void stopThread()
    {
        exit = true;
    }
}
