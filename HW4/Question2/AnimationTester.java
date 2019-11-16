
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * This program implements an animation that moves
 * a car shape.
 */
public class AnimationTester {
    public static void main(String[] args) {
        //region Description ------------------- background of the program --------------------------
        JFrame frame = new JFrame();
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        // make background vertical
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // generate car shapes
        final ArrayList<MoveableShape> shapes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            shapes.add(new CarShape(-500, 0, CAR_WIDTH));
        }
        // add car shapes to JPanel
        final ArrayList<JLabel> jLabels = new ArrayList<>();
        for (int j = 0; j < shapes.size(); j++) {
            ShapeIcon icon1 = new ShapeIcon(shapes.get(j),
                    ICON_WIDTH, ICON_HEIGHT);
            final JLabel label_1 = new JLabel(icon1);
            jLabels.add(label_1);
            contentPane.add(label_1);
        }
        // set frame content
        frame.setContentPane(contentPane);
        frame.setSize(1000, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        //endregion region Description ------------------- background of the program --------------------------


        final int DELAY = 100;
        //region Description ----------------- the first code ---------------------

        // Milliseconds between timer ticks
//      Timer t = new Timer(DELAY, new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent event) {
//            for (int i = 0; i < shapes.size(); i ++){
//               shapes.get(i).moveRight(2);
//               jLabels.get(i).repaint();
//            }
//         }
//      });
//      t.start();

        //endregion Description ----------------- the first code ---------------------

        //region Description ------------------ update code -----------------------------
        // first car
        Thread carThread_1 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    Random random = new Random();
                    shapes.get(0).moveLeft((~0));
                    jLabels.get(0).repaint();

                    try {
                        Thread.sleep(1000 / 30);  // milliseconds
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        //second car
        Thread carThread_2 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    Random random = new Random();
                    shapes.get(1).moveLeft((1 + 1) * (~1));
                    jLabels.get(1).repaint();

                    try {
                        Thread.sleep(1000 / 5);  // milliseconds
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        //third car
        Thread carThread_3 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    Random random = new Random();
                    shapes.get(2).moveLeft((2 + 1) * (~2));
                    jLabels.get(2).repaint();

                    try {
                        Thread.sleep(1000 / 10);  // milliseconds
                    } catch (InterruptedException ex) {
                    }
                }
            }

        };

        // car threads start
        carThread_1.start();
        carThread_2.start();
        carThread_3.start();
        //endregion ------------------ update code -----------------------------
    }

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;

}


