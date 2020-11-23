package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibChoice {

	JFrame frame;
	Librarian_Page lp = new Librarian_Page();
	IssuePage issue = new IssuePage();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public LibChoice() {
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
		
		JButton btnNewButton = new JButton("Book Entries");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lp.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(152, 46, 150 , 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStudentEntries = new JButton("Student Entries");
		String t = btnStudentEntries.getText();
		int s = t.length();
		btnStudentEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				issue.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnStudentEntries.setBounds(152, 129, s*10 , 36);
		frame.getContentPane().add(btnStudentEntries);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn i = new LogIn();
				i.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(1, 275, 90, 23);
		frame.getContentPane().add(btnBack);
	}

}
