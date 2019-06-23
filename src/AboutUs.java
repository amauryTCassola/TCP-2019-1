import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ImageIcon windowIcon = new ImageIcon(this.getClass().getResource("/play.png"));
		setIconImage(windowIcon.getImage());
		setResizable(false);
		
		JLabel lblAbout = new JLabel("ABOUT");
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblAbout, BorderLayout.NORTH);
		
		JLabel lblMusify = new JLabel(Constants.FORMATTED_TEXT);
		lblMusify.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblMusify, BorderLayout.WEST);
	}

}
