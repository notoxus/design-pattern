package paintcommand;

import java.awt.Color;
import java.awt.Rectangle;

public class RectangleCommandFactory implements DrawCommandFactory {
	@Override
	public String getName() {
		return "Rectangle";
	}

	@Override
	public PaintCommand createCommand(DrawingCanvas canvas, Rectangle bounds, Color color, int strokeWidth) {
		return new DrawRectangleCommand(canvas, bounds, color, strokeWidth);
	}

	@Override
	public DrawableShape createPreviewShape(Rectangle bounds, Color color, int strokeWidth) {
		return new RectangleShape(bounds, color, strokeWidth);
	}
}
