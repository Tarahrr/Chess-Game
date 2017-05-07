import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Mouse_c implements MouseListener {

	public void mouseClicked(MouseEvent arg0) {
		int currentX = getX_label(arg0);
		int currentY = getX_label(arg0);
		Piece.pieceType current = objCellMatrix.pieceMatrix[currentX][currentY];


	}

	public int getX_label(MouseEvent event) {
		String str = ((JLabel) event.getComponent()).getName();
		String[] ss = str.split("_");
		return Integer.parseInt(ss[1]);
	}

	public int getY_label(MouseEvent event) {
		String str = ((JLabel) event.getComponent()).getName();
		String[] ss = str.split("_");
		return Integer.parseInt(ss[2]);
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

}
