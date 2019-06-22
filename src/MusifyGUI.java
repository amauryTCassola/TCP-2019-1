

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import org.jfugue.player.Player;

import com.sun.glass.events.MouseEvent;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class MusifyGUI {

	public JFrame frame;
	private JTextArea inputTextBox;
	private JTextArea musicStringTextBox;
	private JTextField bpmInputBox;
	private JSlider volumeSlider;
	private JComboBox instrumentComboBox;
	private JButton playButton;
	
	private Music music;
	private Parser parser;
	private Player player;
	


	/**
	 * Create the application.
	 */
	public MusifyGUI(Music music, Parser parser, Player player) {
		this.music = music;
		this.parser = parser;
		this.player = player;
		initialize();
	}
	
	
	private void getInitialConfigs() {
		Integer inputVolume = volumeSlider.getValue();
		Integer inputBPM = Integer.valueOf(bpmInputBox.getText());
		Integer inputInstrument = instrumentComboBox.getSelectedIndex();
		
		music.setVolume(inputVolume);
		music.setBPM(inputBPM);
		music.setInstrument(inputInstrument);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 394, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton generateButton = new JButton("Generate!");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getInitialConfigs();
				music.generateInitialMusicString();
				
				String inputText = inputTextBox.getText();
				parser.buildMusicString(inputText);
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
		
		instrumentComboBox = new JComboBox();
		instrumentComboBox.setModel(new DefaultComboBoxModel(Constants.INSTRUMENT_LIST));
		instrumentComboBox.setBounds(10, 294, 154, 20);
		frame.getContentPane().add(instrumentComboBox);
		
		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBpm.setBounds(174, 297, 26, 14);
		frame.getContentPane().add(lblBpm);
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(1);
	    formatter.setMaximum(220);
	    formatter.setAllowsInvalid(false);
		
		bpmInputBox = new JFormattedTextField(formatter);
		bpmInputBox.setBounds(204, 294, 65, 20);
		frame.getContentPane().add(bpmInputBox);
		bpmInputBox.setColumns(10);
		
		volumeSlider = new JSlider();
		volumeSlider.setMaximum(127);
		volumeSlider.setBounds(168, 377, 200, 26);
		frame.getContentPane().add(volumeSlider);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVolume.setBounds(249, 349, 55, 23);
		frame.getContentPane().add(lblVolume);
		
		
		ImageIcon playImage = new ImageIcon("images/playResized.png");
		playButton = new JButton(playImage);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.play(music.getMusicString());
			}
		});
		playButton.setBounds(10, 336, 67, 67);
		playButton.setBorderPainted(false);
		frame.getContentPane().add(playButton);

		
	}
}
