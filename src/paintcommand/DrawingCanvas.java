package paintcommand;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawingCanvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private final List<DrawableShape> shapes = new ArrayList<DrawableShape>();
	private DrawableShape previewShape;

	public DrawingCanvas() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(760, 500));
	}

	public void addShape(DrawableShape shape) {
		shapes.add(shape);
		repaint();
	}

	public void clearShapes() {
		shapes.clear();
		previewShape = null;
		repaint();
	}

	public void setPreviewShape(DrawableShape previewShape) {
		this.previewShape = previewShape;
		repaint();
	}

	public void clearPreviewShape() {
		previewShape = null;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics.create();
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (DrawableShape shape : shapes) {
			shape.draw(graphics2d);
		}

		if (previewShape != null) {
			previewShape.draw(graphics2d);
		}

		graphics2d.dispose();
	}
}
