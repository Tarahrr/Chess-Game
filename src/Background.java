import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image backgroundImage;

	public Background(String fileName) {
		backgroundImage = (new ImageIcon(fileName)).getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
	}
}
