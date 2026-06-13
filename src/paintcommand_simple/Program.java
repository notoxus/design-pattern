package paintcommand_simple;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class Program extends JFrame {
	private static final long serialVersionUID = 1L;

	private PaintPanel paintPanel = new PaintPanel();
	private Command ovalCommand = new OvalCommand(paintPanel);
	private Command rectCommand = new RectCommand(paintPanel);

	public Program() {
		setTitle("Demo Paint Using Command");
		setSize(760, 560);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		setJMenuBar(createMenuBar());
		add(createToolBar(), BorderLayout.NORTH);
		add(paintPanel, BorderLayout.CENTER);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		JMenuItem ovalItem = new JMenuItem("Oval");
		ovalItem.addActionListener(e -> ovalCommand.execute());

		JMenuItem rectItem = new JMenuItem("Rect");
		rectItem.addActionListener(e -> rectCommand.execute());

		fileMenu.add(ovalItem);
		fileMenu.add(rectItem);
		menuBar.add(fileMenu);

		return menuBar;
	}

	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();

		JButton ovalButton = new JButton("Oval");
		ovalButton.addActionListener(e -> ovalCommand.execute());

		JButton rectButton = new JButton("Rect");
		rectButton.addActionListener(e -> rectCommand.execute());

		toolBar.add(ovalButton);
		toolBar.add(rectButton);

		return toolBar;
	}

	public static void main(String[] args) {
		new Program().setVisible(true);
	}
}
