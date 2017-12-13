package MusicMain;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javazoom.jl.player.Player;



public class PlayerGui {

	private JFrame frame;
	private JTextField pathField;
	
	private File songFile;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					PlayerGui window = new PlayerGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PlayerGui() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PG’s mp3 Player");
		frame.setBounds(100, 100, 293, 164);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton playBtn = new JButton("Play");
		playBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Player p = new Player(new FileInputStream(songFile));
					p.play();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"No file selected", "Error", JOptionPane.ERROR_MESSAGE);
//					ex.printStackTrace();
				}
			}
		});
		playBtn.setBounds(6, 77, 281, 43);
		frame.getContentPane().add(playBtn);
		
		pathField = new JTextField();
		pathField.setForeground(Color.LIGHT_GRAY);
		pathField.setEditable(false);
		pathField.setText("Song path\n");
		pathField.setBounds(6, 36, 166, 26);
		frame.getContentPane().add(pathField);
		pathField.setColumns(10);
		
		JButton openBtn = new JButton("Open");
		openBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		openBtn.setBounds(170, 36, 117, 29);
		frame.getContentPane().add(openBtn);
		
	}
	
	private void open() {
		try {
			JFileChooser chooser  = new JFileChooser();
			chooser.setDialogTitle("Choose song to load..");
			chooser.showOpenDialog(null);
			songFile = chooser.getSelectedFile();
//			System.out.println("File " + songFile.getName() + ", Selected");
			pathField.setText(songFile.getAbsolutePath());
			
//			if(songFile.getName().endsWith(".mp3")) {
////				JOptionPane.showMessageDialog(null,"Invalid File Type Selected","Error", JOptionPane.ERROR_MESSAGE);
//				open();
//			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
