package MusicMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToPg = new JLabel("Welcome to PG Player");
		lblWelcomeToPg.setBounds(151, 5, 190, 41);
		frame.getContentPane().add(lblWelcomeToPg);
		
		JButton audioBtn = new JButton("MP3 Player");
		audioBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerGui pObject = new PlayerGui(); 
				pObject.main(null);
			}
		});
		audioBtn.setBounds(0, 58, 450, 88);
		frame.getContentPane().add(audioBtn);
		
		JButton videoBtn = new JButton("Video Player");
		videoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				video vObject = new video();
				vObject.main(null);
			}
		});
		videoBtn.setBounds(0, 158, 450, 88);
		frame.getContentPane().add(videoBtn);
	}

}
