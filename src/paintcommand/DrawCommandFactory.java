package paintcommand;

import java.awt.Color;
import java.awt.Rectangle;

public interface DrawCommandFactory {
	String getName();

	PaintCommand createCommand(DrawingCanvas canvas, Rectangle bounds, Color color, int strokeWidth);

	DrawableShape createPreviewShape(Rectangle bounds, Color color, int strokeWidth);
}
