import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CarZoom extends JFrame implements ActionListener {

	// declaring needed UI components

	private JLabel label;
	private Image image;
	private JButton zoomIn, zoomOut;

	// file name
	private String filename = "car.png";

	// size of the image
	private int imWidth = 350, imHeight = 350;

	// GUI constructor
	public CarZoom() {

		// initializing label and buttons
		label = new JLabel("", JLabel.CENTER);
		zoomIn = new JButton("Zoom in");
		zoomOut = new JButton("Zoom out");

		// adding buttons to a panel
		JPanel buttons = new JPanel();
		buttons.add(zoomIn);
		buttons.add(zoomOut);

		// loading image
		loadImage();

		// using border layout, adding components
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		add(buttons, BorderLayout.PAGE_END);
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// adding action listener to the buttons
		zoomIn.addActionListener(this);
		zoomOut.addActionListener(this);
	}

// helper method to load image from file
	private void loadImage() {
		try {
			image = ImageIO.read(new File(filename));
			// rescaling the image to imWidth and imHeight
			image = image.getScaledInstance(imWidth, imHeight, Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(image));
			label.repaint();
		} catch (IOException e) {
			// file not found if there is no photo in the folder
			JOptionPane.showMessageDialog(this,
					filename + " not found" + "\n Make sure you have the file in root " + "directory of your project");
			System.exit(0); // exiting

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// getting source of action
		if (e.getSource().equals(zoomIn)) {
			// increasing image size
			imWidth += 20;
			imHeight += 20;

			// re loading and resizing image
			loadImage();

		} else {
			// decreasing image size
			imWidth -= 20;
			imHeight -= 20;

			// making sure that the image size is always > 0
			if (imWidth <= 0) {
				imWidth = 1;
			}

			if (imHeight <= 0) {
				imHeight = 1;
			}

			loadImage();

		}
	}

	public static void main(String[] args) {

		new CarZoom();

	}

}
