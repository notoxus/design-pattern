package paintcommand;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class AbstractDrawableShape implements DrawableShape {
	private final Rectangle bounds;
	private final Color color;
	private final int strokeWidth;

	protected AbstractDrawableShape(Rectangle bounds, Color color, int strokeWidth) {
		this.bounds = new Rectangle(bounds);
		this.color = color;
		this.strokeWidth = strokeWidth;
	}

	protected Rectangle getBounds() {
		return new Rectangle(bounds);
	}

	protected void prepare(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.setStroke(new BasicStroke(strokeWidth));
	}
}
