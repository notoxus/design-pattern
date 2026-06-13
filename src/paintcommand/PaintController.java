package paintcommand;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaintController {
	private final DrawingCanvas canvas;
	private final Map<String, DrawCommandFactory> factories = new LinkedHashMap<String, DrawCommandFactory>();
	private DrawCommandFactory currentFactory;
	private Color currentColor = new Color(39, 101, 216);
	private int strokeWidth = 2;

	public PaintController(DrawingCanvas canvas) {
		this.canvas = canvas;
		registerTool(new RectangleCommandFactory());
		registerTool(new OvalCommandFactory());
	}

	public void registerTool(DrawCommandFactory factory) {
		factories.put(factory.getName(), factory);
		if (currentFactory == null) {
			currentFactory = factory;
		}
	}

	public List<String> getToolNames() {
		return new ArrayList<String>(factories.keySet());
	}

	public String getCurrentToolName() {
		return currentFactory.getName();
	}

	public void selectTool(String name) {
		DrawCommandFactory factory = factories.get(name);
		if (factory != null) {
			currentFactory = factory;
		}
	}

	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	public DrawableShape createPreviewShape(Rectangle bounds) {
		return currentFactory.createPreviewShape(bounds, currentColor, strokeWidth);
	}

	public void executeCurrentTool(Rectangle bounds) {
		PaintCommand command = currentFactory.createCommand(canvas, bounds, currentColor, strokeWidth);
		command.execute();
	}

	public void clearCanvas() {
		new ClearCanvasCommand(canvas).execute();
	}
}
