package paintcommand;

import java.awt.Color;
import java.awt.Rectangle;

public class DrawRectangleCommand implements PaintCommand {
	private final DrawingCanvas canvas;
	private final Rectangle bounds;
	private final Color color;
	private final int strokeWidth;

	public DrawRectangleCommand(DrawingCanvas canvas, Rectangle bounds, Color color, int strokeWidth) {
		this.canvas = canvas;
		this.bounds = new Rectangle(bounds);
		this.color = color;
		this.strokeWidth = strokeWidth;
	}

	@Override
	public void execute() {
		canvas.addShape(new RectangleShape(bounds, color, strokeWidth));
	}
}
