package paintcommand;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RectangleShape extends AbstractDrawableShape {
	public RectangleShape(Rectangle bounds, Color color, int strokeWidth) {
		super(bounds, color, strokeWidth);
	}

	@Override
	public void draw(Graphics2D graphics) {
		prepare(graphics);
		Rectangle bounds = getBounds();
		graphics.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
