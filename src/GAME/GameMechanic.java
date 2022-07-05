package GAME;

import DUCKS.DuckGreen;
import DUCKS.DuckMain;
import DUCKS.DuckPink;
import DUCKS.DuckYellow;
import OBSTACLES.Cloud;
import OBSTACLES.Tree;
import THREAD.*;
import THREAD.Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static MAIN.Main.Userlife;

public class GameMechanic extends JFrame {
    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon icon = new ImageIcon("IMAGES\\tlo.png");

            g.drawImage(icon.getImage(), 0, 0, this);
            g.drawImage(icon.getImage(), 0, 0, this);
            g.drawImage(icon.getImage(), 0, 0, this);
            g.drawImage(icon.getImage(), 0, 0, this);
        }
    };
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Score:" + Score.getValue());
    JLabel time = new JLabel("Time Elapsed:0");
    GAMEOVER g1 = new GAMEOVER(frame);
    Timer t1 = new Timer(time);
    Tree tree = new Tree(panel);
    Cloud cloud = new Cloud(panel);
    Gun gun = new Gun(panel);
    SpawnDucks spawner = new SpawnDucks(this, gun);

    JProgressBar bar = new JProgressBar(0, 100);
    boolean gameover = false;


    public GameMechanic() {

        panel.setLayout(null);
        gun.addGun(gun);
        gun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GunLvl.increment(1);
                System.out.println(GunLvl.getValue());
                gun.setEnabled(false);
            }
        });

        cloud.addCloud(0, 260, cloud);
        tree.addTree(1200, 500, tree);

        CloudMov s9 = new CloudMov(cloud, cloud, panel);
        s9.start();

        TreeMov s10 = new TreeMov(tree, tree, panel);
        s10.start();


        time.setBounds(200, 30, 80, 80);
        panel.add(time);

        label.setBounds(1000, 30, 80, 80);
        panel.add(label);

        bar.setBounds(400, 50, 500, 50);
        bar.setBackground(Color.RED);
        bar.setValue(Userlife);
        bar.setStringPainted(true);
        panel.add(bar);
        panel.setBackground(Color.YELLOW);
        frame.setSize(1300, 800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Game");
        frame.setVisible(true);
        frame.add(panel);

        g1.start();
        spawner.start();
        t1.start();


        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "closeHotkey");
        panel.getActionMap().put("closeHotkey", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SwingUtilities.invokeLater(GameStartFrame::new);

            }
        });
    }

    public void add(int mode, Gun gun) {


        DuckMain duckM = new DuckMain(panel);
        DuckGreen duckG = new DuckGreen(panel);
        DuckPink duckP = new DuckPink(panel);
        DuckYellow duckY = new DuckYellow(panel);


        duckP.setIcon(new ImageIcon("IMAGES\\Prev.png"));
        duckM.setIcon(new ImageIcon("IMAGES\\Rrev.png"));
        duckG.setIcon(new ImageIcon("IMAGES\\Grev.png"));
        duckY.setIcon(new ImageIcon("IMAGES\\Yrev.png"));
        MovementR s1 = new MovementR(panel, duckM, duckM, bar, Mode.getValue());
        MovementR s2 = new MovementR(panel, duckG, duckG, bar, Mode.getValue());
        MovementR s3 = new MovementR(panel, duckY, duckY, bar, Mode.getValue());
        MovementR s4 = new MovementR(panel, duckP, duckP, bar, Mode.getValue());
        GunCheck s5 = new GunCheck(panel, gun, gun);

        duckM.addDuckMain(0, 260, duckM);
        duckG.addDuckMain(-75, 380, duckG);
        duckP.addDuckMain(-120, 500, duckP);
        duckY.addDuckMain(-20, 620, duckY);


        duckM.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {

                if (clicks[0] == duckM.getPoints()) {
                    duckM.setVisible(false);
                    GunLvl.check(gun);
                    panel.remove(duckM);
                    Score.increment(duckM.getPoints());
                    label.setText("Score " + Score.getValue());
                }

                clicks[0] += 1;
            }

        });
        duckG.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {
                if (clicks[0] == duckG.getPoints()) {
                    duckG.setVisible(false);
                    panel.remove(duckG);
                    GunLvl.check(gun);
                    Score.increment(duckG.getPoints());
                    label.setText("Score " + Score.getValue());
                }

                clicks[0] += 1;
            }

        });
        duckP.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {
                if (clicks[0] == duckP.getPoints()) {
                    duckP.setVisible(false);
                    panel.remove(duckP);
                    GunLvl.check(gun);
                    Score.increment(duckP.getPoints());
                    label.setText("Score " + Score.getValue());
                }

                clicks[0] += 1;
            }

        });
        duckY.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {
                if (clicks[0] == duckY.getPoints()) {
                    duckY.setVisible(false);
                    panel.remove(duckY);
                    GunLvl.check(gun);
                    Score.increment(duckY.getPoints());
                    label.setText("Score " + Score.getValue());
                }

                clicks[0] += 1;
            }

        });

        duckM.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                if (duckM.getX() > 1300 && duckM.isVisible()) {
                    if (Userlife <= 0) {
                        gameover = true;
                    } else {
                        Userlife = Userlife - 10;
                        bar.setValue(Userlife);
                        duckM.setVisible(false);
                        panel.remove(duckM);
                    }


                }
            }
        });

        duckG.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);

                if (duckG.getX() > 1300 && duckG.isVisible()) {
                    Userlife = Userlife - 10;
                    bar.setValue(Userlife);
                    duckG.setVisible(false);
                    panel.remove(duckG);

                }
            }
        });

        duckP.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                if (duckP.getX() > 1300 && duckP.isVisible()) {
                    Userlife = Userlife - 10;
                    bar.setValue(Userlife);
                    duckP.setVisible(false);
                    panel.remove(duckP);

                }
            }
        });

        duckY.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                if (duckY.getX() > 1300 && duckY.isVisible()) {
                    Userlife = Userlife - 10;
                    bar.setValue(Userlife);
                    duckY.setVisible(false);
                    panel.remove(duckY);

                }
            }
        });


        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();

    }


    public void addReverse(int mode, Gun gun) {
        DuckPink duckP = new DuckPink(panel);
        DuckMain duckM = new DuckMain(panel);
        DuckGreen duckG = new DuckGreen(panel);
        DuckYellow duckY = new DuckYellow(panel);
        duckM.setIcon(new ImageIcon("IMAGES\\R.png"));
        duckP.setIcon(new ImageIcon("IMAGES\\P.png"));
        duckG.setIcon(new ImageIcon("IMAGES\\G.png"));
        duckY.setIcon(new ImageIcon("IMAGES\\Y.png"));
        duckP.addDuckMain(1400, 260, duckP);
        duckM.addDuckMain(1360, 380, duckM);
        duckG.addDuckMain(1329, 500, duckG);
        duckY.addDuckMain(1420, 620, duckY);


        duckP.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                if (duckP.getX() < 0 && duckP.isVisible()) {
                    Userlife = Userlife - 10;
                    bar.setValue(Userlife);
                    duckP.setVisible(false);
                    panel.remove(duckP);

                }
            }
        });

        duckG.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                if (duckG.getX() < 0 && duckG.isVisible()) {
                    Userlife = Userlife - 10;
                    bar.setValue(Userlife);
                    duckG.setVisible(false);
                    panel.remove(duckG);

                }
            }
        });

        duckM.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                if (duckM.getX() < 0 && duckM.isVisible()) {
                    Userlife = Userlife - 10;
                    bar.setValue(Userlife);
                    duckM.setVisible(false);
                    panel.remove(duckM);

                }
            }
        });

        duckY.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                if (duckY.getX() < 0 && duckY.isVisible()) {
                    Userlife = Userlife - 10;
                    bar.setValue(Userlife);
                    duckY.setVisible(false);
                    panel.remove(duckY);

                }
            }
        });

        duckP.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {

                if (clicks[0] == duckP.getPoints()) {
                    Score.increment(duckP.getPoints());
                    duckP.setVisible(false);
                    GunLvl.check(gun);
                    panel.remove(duckP);
                    label.setText("Score:" + Score.getValue());
                }
                clicks[0] += 1;

            }
        });

        duckG.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {

                if (clicks[0] == duckG.getPoints()) {
                    Score.increment(duckG.getPoints());
                    duckG.setVisible(false);
                    GunLvl.check(gun);
                    panel.remove(duckG);
                    label.setText("Score:" + Score.getValue());
                }
                clicks[0] += 1;
            }
        });

        duckM.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {

                if (clicks[0] == duckM.getPoints()) {
                    Score.increment(duckM.getPoints());
                    duckM.setVisible(false);
                    GunLvl.check(gun);
                    panel.remove(duckM);
                    label.setText("Score:" + Score.getValue());
                }
                clicks[0] += 1;
            }
        });

        duckY.addActionListener(new ActionListener() {
            int[] clicks = {1};

            @Override
            public void actionPerformed(ActionEvent e) {

                if (clicks[0] == duckY.getPoints()) {
                    Score.increment(duckY.getPoints());
                    duckY.setVisible(false);
                    GunLvl.check(gun);
                    panel.remove(duckY);
                    label.setText("Score:" + Score.getValue());
                }
                clicks[0] += 1;
            }
        });

        MovementL s1 = new MovementL(panel, duckP, duckP, Mode.getValue());
        MovementL s2 = new MovementL(panel, duckG, duckG, Mode.getValue());
        MovementL s3 = new MovementL(panel, duckM, duckM, Mode.getValue());
        MovementL s4 = new MovementL(panel, duckY, duckY, Mode.getValue());
        s1.start();
        s2.start();
        s3.start();
        s4.start();
    }


}
