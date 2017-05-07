import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static JFrame frame;
	public static Background back;
	public static JLabel[][] allLables;

	public static void main(String[] args) {
		setFrameProperties();

		// for (int row = 0; row < 8; row++) {
		// for (int column = 0; column < 8; column++) {
		// System.out.print(objCellMatrix.pieceMatrix[row][column]+" ");
		// }
		// System.out.println(" ");
		// }

	}

	public static void setFrameProperties() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(418, 440);
		frame.setLocationRelativeTo(null);
		frame.setTitle("chess");
		back = new Background("./background.png");
		objCellMatrix.resetMatrix();
		objCellMatrix.setLables();
		frame.add(back);
		frame.setVisible(true);

	}

	public static void setLabels() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				// if()
				// allLables[i][j] = new JLabel(image);
			}
	}

}
