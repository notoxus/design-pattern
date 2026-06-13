package paintcommand;

public class ClearCanvasCommand implements PaintCommand {
	private final DrawingCanvas canvas;

	public ClearCanvasCommand(DrawingCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void execute() {
		canvas.clearShapes();
	}
}
