package demo_mvc_strategy;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConvertView extends JFrame {
	private ControllerNumber controller;
	private JLabel inputLabel, outputLabel;
	private JTextField inputField, outputField;
	private JPanel panel1, panel2, panel3;
	private JButton oct, bin, hex;

	public ConvertView() throws HeadlessException {
		controller = new ControllerNumber(new ModelNumber());
		
		setTitle("MVC Strategy Converter");
		setLayout(new BorderLayout());
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		inputLabel = new JLabel("Nhập số nguyên hệ Dec:");
		inputField = new JTextField(15);
		panel1 = new JPanel(new FlowLayout());
		panel1.add(inputLabel);
		panel1.add(inputField);

		bin = new JButton("BIN");
		oct = new JButton("OCT");
		hex = new JButton("HEX");
		panel2 = new JPanel(new FlowLayout());
		panel2.add(bin);
		panel2.add(oct);
		panel2.add(hex);

		outputLabel = new JLabel("Kết quả:");
		outputField = new JTextField(15);
		outputField.setEditable(false);
		panel3 = new JPanel(new FlowLayout());
		panel3.add(outputLabel);
		panel3.add(outputField);

		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);

		bin.addActionListener(e -> {
			controller.setStrategy(new BinConvertStrategy());
			outputField.setText(controller.convert(inputField.getText()));
			});
		oct.addActionListener(e -> {
			controller.setStrategy(new OctConvertStrategy());
			outputField.setText(controller.convert(inputField.getText()));
			});

		hex.addActionListener(e -> {
			controller.setStrategy(new HexConvertStrategy());
			outputField.setText(controller.convert(inputField.getText()));
			});

		setVisible(true);
	}
}