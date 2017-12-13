package MusicMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class PlayerGui {

	private JFrame frmPgsMpPlayer;
	private JTextField pathField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					PlayerGui window = new PlayerGui();
					window.frmPgsMpPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPgsMpPlayer = new JFrame();
		frmPgsMpPlayer.setTitle("PG’s mp3 Player");
		frmPgsMpPlayer.setBounds(100, 100, 293, 164);
		frmPgsMpPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPgsMpPlayer.setLocationRelativeTo(null);
		frmPgsMpPlayer.getContentPane().setLayout(null);
		
		JButton startBtn = new JButton("Start");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		startBtn.setBounds(6, 77, 281, 43);
		frmPgsMpPlayer.getContentPane().add(startBtn);
		
		pathField = new JTextField();
		pathField.setForeground(Color.LIGHT_GRAY);
		pathField.setEditable(false);
		pathField.setText("Song path\n");
		pathField.setBounds(6, 36, 166, 26);
		frmPgsMpPlayer.getContentPane().add(pathField);
		pathField.setColumns(10);
		
		JButton openBtn = new JButton("Open");
		openBtn.setBounds(170, 36, 117, 29);
		frmPgsMpPlayer.getContentPane().add(openBtn);
		
	}
}
