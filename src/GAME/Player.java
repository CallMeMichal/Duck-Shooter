package GAME;

import THREAD.GAMEOVER;

import java.io.*;

import static MAIN.Main.nick;

public class Player implements Serializable {



    public Player() throws IOException, ClassNotFoundException {
        Score score = new Score();
        Person person = new Person(nick, score.getValue());
        serialization(person);


    }

    public void serialization(Person person) throws IOException {

        FileOutputStream fout = new FileOutputStream("IMAGES\\plik1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }

}


