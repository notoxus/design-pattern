package paintcommand;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class OvalShape extends AbstractDrawableShape {
	public OvalShape(Rectangle bounds, Color color, int strokeWidth) {
		super(bounds, color, strokeWidth);
	}

	@Override
	public void draw(Graphics2D graphics) {
		prepare(graphics);
		Rectangle bounds = getBounds();
		graphics.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
