import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class CircleColor 
{

        JButton greenButton, redButton, blueButton;
        CircleFrame paintGUI;

        ActionListener actionListener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == greenButton) {
                                paintGUI.green();
                        } else if (e.getSource() == redButton) {
                                paintGUI.red();
                        } else if (e.getSource() == blueButton) {
                                paintGUI.blue();
                        }
                }
        };

        public static void main(String[] args) 
        {
                new CircleColor().repaint();
        }

        public void repaint() 
        {
                // create main frame
                JFrame frame = new JFrame("Color Changer");
                Container content = frame.getContentPane();

                // set layout on content pane
                content.setLayout(new BorderLayout());

                // create draw area
                paintGUI = new CircleFrame();

                // add to content pane
                content.add(paintGUI, BorderLayout.CENTER);

                // create controls to apply colors and call clear feature
                JPanel controls = new JPanel();
                greenButton = new JButton("Repaint Green");
                greenButton.addActionListener(actionListener);
                redButton = new JButton("Repaint Red");
                redButton.addActionListener(actionListener);
                blueButton = new JButton("Repaint Blue");
                blueButton.addActionListener(actionListener);

                controls.add(greenButton);
                controls.add(redButton);
                controls.add(blueButton);

                // add to content pane
                content.add(controls, BorderLayout.SOUTH);

                frame.setSize(500, 550);
                
                // show the swing paint result
                frame.setVisible(true);

        }

}
