import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private Music music;
	private Parser parser;
	private Player player;
	private Thread playThread;
	private ImageIcon playButton, stopButton;
	private TextArea textAreaInput;
	private JLabel lblBPMValue, lblVolumeValue;
	private int currentVolume = Constants.VOLUME_DEFAULT;
	private int currentBPM = Constants.BPM_DEFAULT;
	private int currentInstrumentIndex = Constants.INSTRUMENT_DEFAULT;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Boolean saveMidiFile() {
		Pattern savingPattern = new Pattern(music.getMusicString());
		
		try {
			MidiFileManager.savePatternToMidi(savingPattern, new File("Generated Music.mid"));
			return true;
		} catch (IOException ex) {
			return false;
		}
	}
	
	private void InitMusify() {
		MusicMapManager musicMap = new MusicMapManager();
		this.music = new Music(Constants.VOLUME_DEFAULT, Constants.BPM_DEFAULT, Constants.INSTRUMENT_DEFAULT, Constants.OCTAVE_DEFAULT);
		this.parser = new Parser(musicMap, this.music);
		this.player = new Player();
		this.playThread = new Thread();
	}
	/**
	 * Create the frame.
	 */
	public GUI() {
		
		InitMusify();
		
		setResizable(false);
		setTitle("Musify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 465);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon windowIcon = new ImageIcon(this.getClass().getResource("/play.png"));
		setIconImage(windowIcon.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 384, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Read string from .txt");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Path filePath;
				String musicStringTxt; //the content of the fil
				
				JFileChooser chooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt");
		        chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		        	filePath = Paths.get(chooser.getSelectedFile().getAbsolutePath());
		        	try {
						musicStringTxt = new String(Files.readString(filePath));
						textAreaInput.setText(musicStringTxt);
					} catch (IOException e) {
						return;
					}
		        }	        
			}
		});

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save to .MIDI");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveMidiFile();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmMenuItemAbout = new JMenuItem("About");
		mntmMenuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutUs abtUsFrame = new AboutUs();
				abtUsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				abtUsFrame.setVisible(true);
			}
		});

		mnNewMenu_1.add(mntmMenuItemAbout);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Input", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelInput.setBounds(10, 33, 354, 96);
		contentPane.add(panelInput);
		panelInput.setLayout(new BorderLayout(0, 0));
		
		textAreaInput = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		panelInput.add(textAreaInput, BorderLayout.CENTER);
		
		JPanel panelOutput = new JPanel();
		panelOutput.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Output", TitledBorder.LEFT, TitledBorder.TOP, null, UIManager.getColor("Button.disabledForeground")));
		panelOutput.setBounds(10, 140, 354, 96);
		contentPane.add(panelOutput);
		panelOutput.setLayout(new BorderLayout(0, 0));
		
		TextArea textAreaOutput = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textAreaOutput.setEditable(false);
		panelOutput.add(textAreaOutput, BorderLayout.CENTER);
		
		playButton = new ImageIcon(this.getClass().getResource("/play.png"));
		Image imageaux = playButton.getImage();
		Image newimgaux = imageaux. getScaledInstance(Constants.STANDARD_BUTTON_WIDTH, Constants.STANDARD_BUTTON_HEIGHT,  java.awt.Image.SCALE_SMOOTH);
		playButton = new ImageIcon(newimgaux);
		
		stopButton = new ImageIcon(this.getClass().getResource("/stop.png"));
		imageaux = stopButton.getImage();
		newimgaux = imageaux. getScaledInstance(Constants.STANDARD_BUTTON_WIDTH, Constants.STANDARD_BUTTON_HEIGHT,  java.awt.Image.SCALE_SMOOTH);
		stopButton = new ImageIcon(newimgaux);
		
		
		JButton btnPlay = new JButton();
		btnPlay.setOpaque(false);
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!playThread.isAlive()) {
					playThread = new Thread(new Runnable() {
					    public void run() {
					    	String mString = music.getMusicString(); 
					    	if(!mString.isEmpty()) {
					    		player.play(mString);
					    	}
					    	btnPlay.setIcon(playButton);
					    	return;
					    }
					});
					btnPlay.setIcon(stopButton);
					playThread.start();
				} else {
					playThread.stop();
					player.play("");
					btnPlay.setIcon(playButton);
				}
			}
		});
		btnPlay.setBackground(Color.BLACK);
		btnPlay.setBorderPainted(false);
		btnPlay.setBounds(275, 332, 89, 70);
		btnPlay.setIcon(playButton);
		contentPane.add(btnPlay);
		
		JButton btnGenerate = new JButton("Generate!");
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				music.generateInitialMusicString(currentVolume, currentBPM, 
						currentInstrumentIndex);
				
				String inputText = textAreaInput.getText();
				parser.buildMusicString(inputText);
				textAreaOutput.setText(music.getMusicString());
				
			}
			
		});
		btnGenerate.setBounds(275, 288, 89, 33);
		contentPane.add(btnGenerate);
		
		JPanel panelOptions = new JPanel();
		panelOptions.setBorder(new TitledBorder(null, "Options", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelOptions.setBounds(10, 257, 255, 158);
		contentPane.add(panelOptions);
		panelOptions.setLayout(new BoxLayout(panelOptions, BoxLayout.Y_AXIS));
		
		JPanel panelInstrument = new JPanel();
		panelOptions.add(panelInstrument);
		panelInstrument.setBorder(new TitledBorder(new LineBorder(new Color(240, 240, 240)), "Instrument", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelInstrument.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBoxInstrument = new JComboBox();
		comboBoxInstrument.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					currentInstrumentIndex = Constants.INSTRUMENTS_MAP.get(comboBoxInstrument.getSelectedIndex());
				}
			}
		});
		panelInstrument.add(comboBoxInstrument);
		comboBoxInstrument.setModel(new DefaultComboBoxModel(Constants.INSTRUMENT_LIST));
		
		JPanel panelBPM = new JPanel();
		panelOptions.add(panelBPM);
		panelBPM.setBorder(new TitledBorder(new LineBorder(new Color(240, 240, 240)), "BPM", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBPM.setLayout(new BorderLayout(0, 0));
		
		JSlider sliderBPM = new JSlider();
		sliderBPM.setValue(Constants.BPM_DEFAULT);
		sliderBPM.setMaximum(Constants.BPM_MAX);
		sliderBPM.setMinimum(Constants.BPM_MIN);
		sliderBPM.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				currentBPM = sliderBPM.getValue();
				lblBPMValue.setText(String.valueOf(currentBPM));
			}
		});
		panelBPM.add(sliderBPM, BorderLayout.CENTER);
		
		lblBPMValue = new JLabel(String.valueOf(Constants.BPM_DEFAULT));
		panelBPM.add(lblBPMValue, BorderLayout.EAST);
		
		JPanel panelVolume = new JPanel();
		panelOptions.add(panelVolume);
		panelVolume.setBorder(new TitledBorder(new LineBorder(new Color(240, 240, 240)), "Volume", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelVolume.setLayout(new BorderLayout(0, 0));
		
		JSlider sliderVolume = new JSlider();
		sliderVolume.setValue(Constants.VOLUME_DEFAULT);
		sliderVolume.setMaximum(Constants.MAX_VOLUME);
		sliderVolume.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				currentVolume = sliderVolume.getValue();
				lblVolumeValue.setText(String.valueOf(currentVolume));
			}
		});
		panelVolume.add(sliderVolume, BorderLayout.CENTER);
		
		lblVolumeValue = new JLabel(String.valueOf(Constants.VOLUME_DEFAULT));
		panelVolume.add(lblVolumeValue, BorderLayout.EAST);
	}
}
