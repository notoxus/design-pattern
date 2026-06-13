package paintcommand;

import java.awt.Color;
import java.awt.Rectangle;

public class OvalCommandFactory implements DrawCommandFactory {
	@Override
	public String getName() {
		return "Oval";
	}

	@Override
	public PaintCommand createCommand(DrawingCanvas canvas, Rectangle bounds, Color color, int strokeWidth) {
		return new DrawOvalCommand(canvas, bounds, color, strokeWidth);
	}

	@Override
	public DrawableShape createPreviewShape(Rectangle bounds, Color color, int strokeWidth) {
		return new OvalShape(bounds, color, strokeWidth);
	}
}
