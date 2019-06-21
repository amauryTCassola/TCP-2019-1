

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MusifyGUI {

	public JFrame frame;
	private JTextArea inputTextBox;
	private JTextArea musicStringTextBox;
	private JTextField bpmInputBox;
	
	private Music music;
	private Parser parser;


	/**
	 * Create the application.
	 */
	public MusifyGUI(Music music, Parser parser) {
		this.music = music;
		this.parser = parser;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 394, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton generateButton = new JButton("Generate!");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputText = inputTextBox.getText();
				parser.buildMusicString(inputText);;
				musicStringTextBox.setText(music.getMusicString());
								
			}
		});
		generateButton.setBounds(279, 293, 89, 23);
		frame.getContentPane().add(generateButton);
		
		inputTextBox = new JTextArea();
		inputTextBox.setForeground(new Color(0, 0, 0));
		inputTextBox.setLineWrap(true);
		inputTextBox.setBounds(10, 75, 358, 87);
		frame.getContentPane().add(inputTextBox);
		
		musicStringTextBox = new JTextArea();
		musicStringTextBox.setLineWrap(true);
		musicStringTextBox.setEditable(false);
		musicStringTextBox.setBounds(10, 174, 358, 87);
		frame.getContentPane().add(musicStringTextBox);
		
		JComboBox instrumentComboBox = new JComboBox();
		instrumentComboBox.setBounds(10, 294, 112, 20);
		frame.getContentPane().add(instrumentComboBox);
		
		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBpm.setBounds(154, 297, 26, 14);
		frame.getContentPane().add(lblBpm);
		
		bpmInputBox = new JTextField();
		bpmInputBox.setBounds(184, 294, 65, 20);
		frame.getContentPane().add(bpmInputBox);
		bpmInputBox.setColumns(10);
	}
}
