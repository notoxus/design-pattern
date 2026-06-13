package paintcommand_simple;

public class OvalCommand implements Command {
	private PaintPanel paintPanel;

	public OvalCommand(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
	}

	@Override
	public void execute() {
		paintPanel.drawOval();
	}
}
