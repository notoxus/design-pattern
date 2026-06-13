package paintcommand_simple;

public class RectCommand implements Command {
	private PaintPanel paintPanel;

	public RectCommand(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
	}

	@Override
	public void execute() {
		paintPanel.drawRect();
	}
}
