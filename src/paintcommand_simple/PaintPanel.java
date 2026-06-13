package paintcommand_simple;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private String shape = "";

	public void drawOval() {
		shape = "Oval";
		repaint();
	}

	public void drawRect() {
		shape = "Rect";
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (shape.equals("Oval")) {
			g.setColor(Color.GREEN);
			g.fillOval(20, 25, 150, 150);
		}

		if (shape.equals("Rect")) {
			g.setColor(Color.BLUE);
			g.fillRect(300, 200, 150, 190);
		}
	}
}
