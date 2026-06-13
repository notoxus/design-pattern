package paintcommand;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class PaintFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int MIN_SHAPE_SIZE = 4;

	private final DrawingCanvas canvas = new DrawingCanvas();
	private final PaintController controller = new PaintController(canvas);
	private final Map<String, JToggleButton> toolButtons = new LinkedHashMap<String, JToggleButton>();
	private final Map<String, JRadioButtonMenuItem> toolMenuItems = new LinkedHashMap<String, JRadioButtonMenuItem>();
	private Point startPoint;

	public PaintFrame() {
		super("Paint Command");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setJMenuBar(createMenuBar());
		add(createToolBar(), BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		add(createStatusPanel(), BorderLayout.SOUTH);
		installMouseDrawing();
		syncSelectedTool();
		pack();
		setLocationRelativeTo(null);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu drawMenu = new JMenu("Draw");
		ButtonGroup group = new ButtonGroup();

		for (String toolName : controller.getToolNames()) {
			JRadioButtonMenuItem item = new JRadioButtonMenuItem(toolName);
			item.addActionListener(event -> selectTool(toolName));
			toolMenuItems.put(toolName, item);
			group.add(item);
			drawMenu.add(item);
		}

		drawMenu.addSeparator();
		JMenuItem colorItem = new JMenuItem("Color...");
		colorItem.addActionListener(event -> chooseColor());
		drawMenu.add(colorItem);

		JMenuItem clearItem = new JMenuItem("Clear");
		clearItem.addActionListener(event -> controller.clearCanvas());
		drawMenu.add(clearItem);

		menuBar.add(drawMenu);
		return menuBar;
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		ButtonGroup group = new ButtonGroup();

		for (String toolName : controller.getToolNames()) {
			JToggleButton button = new JToggleButton(toolName);
			button.setToolTipText("Draw " + toolName.toLowerCase());
			button.addActionListener(event -> selectTool(toolName));
			toolButtons.put(toolName, button);
			group.add(button);
			toolBar.add(button);
		}

		toolBar.addSeparator();
		JButton colorButton = new JButton("Color");
		colorButton.setToolTipText("Choose drawing color");
		colorButton.addActionListener(event -> chooseColor());
		toolBar.add(colorButton);

		JButton clearButton = new JButton("Clear");
		clearButton.setToolTipText("Clear canvas");
		clearButton.addActionListener(event -> controller.clearCanvas());
		toolBar.add(clearButton);

		return toolBar;
	}

	private JPanel createStatusPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JSlider strokeSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 8, controller.getStrokeWidth());
		strokeSlider.setMajorTickSpacing(1);
		strokeSlider.setPaintTicks(true);
		strokeSlider.setToolTipText("Stroke width");
		strokeSlider.addChangeListener(event -> controller.setStrokeWidth(strokeSlider.getValue()));
		panel.add(strokeSlider);
		return panel;
	}

	private void installMouseDrawing() {
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				startPoint = event.getPoint();
			}

			@Override
			public void mouseDragged(MouseEvent event) {
				if (startPoint == null) {
					return;
				}
				Rectangle bounds = createBounds(startPoint, event.getPoint());
				canvas.setPreviewShape(controller.createPreviewShape(bounds));
			}

			@Override
			public void mouseReleased(MouseEvent event) {
				if (startPoint == null) {
					return;
				}
				Rectangle bounds = createBounds(startPoint, event.getPoint());
				canvas.clearPreviewShape();
				startPoint = null;
				if (bounds.width >= MIN_SHAPE_SIZE && bounds.height >= MIN_SHAPE_SIZE) {
					controller.executeCurrentTool(bounds);
				}
			}
		};
		canvas.addMouseListener(adapter);
		canvas.addMouseMotionListener(adapter);
	}

	private Rectangle createBounds(Point firstPoint, Point secondPoint) {
		int x = Math.min(firstPoint.x, secondPoint.x);
		int y = Math.min(firstPoint.y, secondPoint.y);
		int width = Math.abs(firstPoint.x - secondPoint.x);
		int height = Math.abs(firstPoint.y - secondPoint.y);
		return new Rectangle(x, y, width, height);
	}

	private void chooseColor() {
		Color selectedColor = JColorChooser.showDialog(this, "Choose Color", controller.getCurrentColor());
		if (selectedColor != null) {
			controller.setCurrentColor(selectedColor);
		}
	}

	private void selectTool(String toolName) {
		controller.selectTool(toolName);
		syncSelectedTool();
	}

	private void syncSelectedTool() {
		String selected = controller.getCurrentToolName();
		JToggleButton button = toolButtons.get(selected);
		if (button != null) {
			button.setSelected(true);
		}
		JRadioButtonMenuItem menuItem = toolMenuItems.get(selected);
		if (menuItem != null) {
			menuItem.setSelected(true);
		}
	}
}
