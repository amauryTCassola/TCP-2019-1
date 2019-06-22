
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import org.jfugue.player.Player;

import com.sun.glass.events.MouseEvent;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Insets;


public class MusifyGUI extends JPanel {
	
	private Music music;
	private Parser parser;
	private Player player;
	
	public JFrame frame;
	private JTextArea inputTextBox, musicStringTextBox;
	private JSlider volumeSlider, sliderBPM;
	private JComboBox instrumentComboBox;
	private JButton playButton;

	JPanel panelHeader;
	JPanel panelInput;
	JPanel panelMusicString;
	JPanel panelConfigs;
	
	JPanel panelPlay;
	JPanel panelPlayLeft;
	JPanel panelPlayRight;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem readTxt, saveMIDI;
	
	public MusifyGUI() {
		
		MusicMapManager musicMap = new MusicMapManager();
		this.music = new Music(Constants.VOLUME_DEFAULT, Constants.BPM_DEFAULT, 
				Constants.INSTRUMENT_DEFAULT, Constants.OCTAVE_DEFAULT);
		this.parser = new Parser(musicMap, music);
		this.player = new Player();
		
		GridLayout layout = new GridLayout(5,2);
		
		panelHeader = new JPanel();
		panelHeader.setBorder(new EmptyBorder(10, 10, 10, 10));
		//panelHeader.add(inputTextBox);
		add(panelHeader);
		
		buildInputPanel();
		add(panelInput);
		
		buildMusicStringPanel();
		add(panelMusicString);		
		
		buildConfigsPanel();
		add(panelConfigs);
		
		buildPlayPanel();
		add(panelPlay);
	}

	public void startMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu("Files");
		readTxt = new JMenuItem("Read string from a .txt file");
		saveMIDI = new JMenuItem("Save music to a .MIDI file");
		menu.add(readTxt);
		menu.add(saveMIDI);
		menuBar.add(menu);
		
		readTxt.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	System.out.print("TESTE TXT");
		    }
		});
		
		saveMIDI.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	System.out.print("TESTE MIDI");
		    }
		});
	}
	
	private void buildPlayPanel() {
		panelPlay = new JPanel();
		
		GridLayout playPanelLayout = new GridLayout(1,2);
		panelPlay.setLayout(playPanelLayout);
		
		
		panelPlayLeft = new JPanel();
		FlowLayout panelPlayLeftLayout = new FlowLayout(FlowLayout.LEADING);
		panelPlayLeft.setLayout(panelPlayLeftLayout);
		panelPlay.add(panelPlayLeft);
		
		ImageIcon playImage = new ImageIcon("images/playResized.png");
		playButton = new JButton(playImage);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.play(music.getMusicString());
			}
		});
		playButton.setBorderPainted(false);
		panelPlayLeft.add(playButton);

		
		panelPlayRight = new JPanel();
		FlowLayout panelPlayRightLayout = new FlowLayout(FlowLayout.CENTER);
		panelPlayRight.setLayout(panelPlayRightLayout);
		panelPlay.add(panelPlayRight);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPlayRight.add(lblVolume);
		
		
		volumeSlider = new JSlider();
		volumeSlider.setMaximum(127);
		panelPlayRight.add(volumeSlider);
		
		
	}



	private void buildConfigsPanel() {
		
		panelConfigs = new JPanel();
		
		GridBagConstraints gridConfig = new GridBagConstraints();
		GridBagLayout layoutConfig = new GridBagLayout();
		panelConfigs.setLayout(layoutConfig);
		
		
		instrumentComboBox = new JComboBox();
		instrumentComboBox.setModel(new DefaultComboBoxModel(Constants.INSTRUMENT_LIST));
		gridConfig.gridx = 0;
		gridConfig.gridy = 0;
		gridConfig.weightx = 0.5;
		panelConfigs.add(instrumentComboBox, gridConfig);
		
		
		JLabel lblBpm = new JLabel("BPM");
		lblBpm.setFont(new Font("Tahoma", Font.BOLD, 11));
		gridConfig.gridx = 1;
		gridConfig.gridy = 0;
		gridConfig.anchor = GridBagConstraints.EAST;
		panelConfigs.add(lblBpm, gridConfig);
		
		sliderBPM = new JSlider();
		sliderBPM.setMaximum(220);
		sliderBPM.setMinimum(1);
		gridConfig.gridx = 2;
		gridConfig.gridy = 0;
		gridConfig.anchor = GridBagConstraints.WEST;
		gridConfig.ipadx = 20;
		panelConfigs.add(sliderBPM, gridConfig);
		
		
		JButton generateButton = new JButton("Generate!");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getInitialConfigs();
				
				music.generateInitialMusicString();
				
				String inputText = inputTextBox.getText();
				parser.buildMusicString(inputText);
				musicStringTextBox.setText(music.getMusicString());
								
			}

			private void getInitialConfigs() {
				Integer inputVolume = volumeSlider.getValue();
				Integer inputBPM = sliderBPM.getValue();
				Integer inputInstrument = instrumentComboBox.getSelectedIndex();
				
				music.setVolume(inputVolume);
				music.setBPM(inputBPM);
				music.setInstrument(inputInstrument);
			}
		});
		gridConfig.gridx = 3;
		gridConfig.gridy = 0;
		gridConfig.weightx = 0.5;
		panelConfigs.add(generateButton, gridConfig);
	}



	private void buildMusicStringPanel() {
		musicStringTextBox = new JTextArea();
		musicStringTextBox.setLineWrap(true);
		musicStringTextBox.setEditable(false);
		musicStringTextBox.setColumns(32);
		musicStringTextBox.setRows(5);
		JScrollPane scrollPaneMusicStringBox = new JScrollPane(musicStringTextBox);
		panelMusicString = new JPanel();
		panelMusicString.add(scrollPaneMusicStringBox);
	}



	private void buildInputPanel() {
		inputTextBox = new JTextArea();
		inputTextBox.setLineWrap(true);
		inputTextBox.setColumns(32);
		inputTextBox.setRows(5);
		JScrollPane scrollPaneInputTextBox = new JScrollPane(inputTextBox);
		panelInput = new JPanel();
		panelInput.add(scrollPaneInputTextBox);
	}

	
	
	public static void main(String[] args) {
		
		MusifyGUI musify = new MusifyGUI();
		JFrame jf = new JFrame();
		musify.startMenu();
		musifyWindowInitializer(musify, jf);
	}


	private static void musifyWindowInitializer(MusifyGUI musify, JFrame jf) {
		jf.setTitle("Musify");
		ImageIcon programIcon = new ImageIcon("images/icon.png");
		jf.setIconImage(programIcon.getImage());
		jf.setBounds(500, 100, 400, 530);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setJMenuBar(musify.menuBar);
		jf.getContentPane().add(musify);
	}
}
