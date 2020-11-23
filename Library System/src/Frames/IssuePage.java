package Frames;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Classes.BookDB;
import Classes.IssueDB;
import Classes.initDB;

public class IssuePage {
		JFrame frame;
		private JTable table;
		private JTextField bname;
		private JTextField search_book;
		private JTextField sname;
		private JTextField sid;
		private JTextField sroll;
		private JTextField search;

		/**
		 * Launch the application.
		 */
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						IssuePage window = new IssuePage();
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
		public IssuePage() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {			
			frame = new JFrame();
			frame.setTitle("Library Management System");
			frame.setBounds(100, 100, 721, 484);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 705, 445);
			frame.getContentPane().add(tabbedPane);
			
			JDesktopPane issuebook = new JDesktopPane();
			issuebook.setBackground(Color.WHITE);
			tabbedPane.addTab("Issue Book", null, issuebook, null);
			
			bname = new JTextField();
			bname.setBounds(292, 25, 191, 40);
			issuebook.add(bname);
			bname.setColumns(10);
			
			sname = new JTextField();
			sname.setColumns(10);
			sname.setBounds(292, 89, 191, 40);
			issuebook.add(sname);
			
			sid = new JTextField();
			sid.setColumns(10);
			sid.setBounds(292, 149, 191, 40);
			issuebook.add(sid);
			
			sid.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		           char c = e.getKeyChar();
		           if (!(Character.isDigit(c) ||
		              (c == KeyEvent.VK_BACK_SPACE) ||
		              (c == KeyEvent.VK_DELETE))) {
		                e.consume();
		              }
		         }
		       });
			
			
			sroll = new JTextField();
			sroll.setColumns(10);
			sroll.setBounds(292, 220, 191, 40);
			issuebook.add(sroll);
			
			sroll.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		           char c = e.getKeyChar();
		           if (!(Character.isDigit(c) ||
		              (c == KeyEvent.VK_BACK_SPACE) ||
		              (c == KeyEvent.VK_DELETE))) {
		                e.consume();
		              }
		         }
		       });
			JLabel lblEnterBookName = new JLabel("Enter Book name");
			lblEnterBookName.setBounds(101, 28, 150, 35);
			issuebook.add(lblEnterBookName);
			
			JLabel lblEnterAuthorName = new JLabel("Enter Student name");
			lblEnterAuthorName.setBounds(101, 92, 150, 35);
			issuebook.add(lblEnterAuthorName);
			
			JLabel lblEnterPublicationName = new JLabel("Enter Student id");
			lblEnterPublicationName.setBounds(101, 152, 167, 35);
			issuebook.add(lblEnterPublicationName);
			
			JLabel lblEnterNumberOf = new JLabel("Enter Student roll number");
			lblEnterNumberOf.setBounds(101, 223, 200, 35);
			issuebook.add(lblEnterNumberOf);
			
			final JLabel label = new JLabel("");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(101, 352, 400, 14);
			issuebook.add(label);
			
			JButton addb = new JButton("Issue Book");
			addb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String bn = bname.getText();
					String sn = sname.getText();
					int id = Integer.parseInt(sid.getText());
					int roll = Integer.parseInt(sroll.getText());
					
					System.out.println(bn);
					if(BookDB.search(bn)){
						if(IssueDB.save(sn, roll, bn, id)  == 1)
							label.setText("Book issued successfully!");
						else
							label.setText("Book not available!");
					}
					else
						label.setText("Book does not exists!");
					
					clear();
				}
				public void clear() {
					bname.setText(null);
					sname.setText(null);
					sid.setText(null);
					sroll.setText(null);
				}
			});
			addb.setBounds(230, 304, 150, 37);
			issuebook.add(addb);
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LibChoice l= new LibChoice();
					l.frame.setVisible(true);
					frame.setVisible(false);
				}
			});
			btnBack.setBounds(0, 394, 70, 23);
			issuebook.add(btnBack);
			
			
			
			
			
			/////////// Return book //////////////
			
			JDesktopPane returnbook = new JDesktopPane();
			returnbook.setBackground(Color.WHITE);
			tabbedPane.addTab("Return Book", null, returnbook, null);
			
			JLabel label_1 = new JLabel("Enter Student id");
			label_1.setBounds(101, 28, 135, 35);
			returnbook.add(label_1);
			
			search = new JTextField();
			search.setColumns(10);
			search.setBounds(292, 25, 191, 40);
			returnbook.add(search);
			search.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		           char c = e.getKeyChar();
		           if (!(Character.isDigit(c) ||
		              (c == KeyEvent.VK_BACK_SPACE) ||
		              (c == KeyEvent.VK_DELETE))) {
		                e.consume();
		              }
		         }
		       });
			
			
			JLabel label_2 = new JLabel("Enter Book name");
			label_2.setBounds(101, 92, 135, 35);
			returnbook.add(label_2);
			
			search_book = new JTextField();
			search_book.setColumns(10);
			search_book.setBounds(292, 89, 191, 40);
			returnbook.add(search_book);

			final JLabel l_name = new JLabel("");
			l_name.setBounds(180, 182, 400, 35);
			returnbook.add(l_name);
			
			
			JButton btnNewButton = new JButton("Return");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clear();
					String book = search_book.getText();
					int key = Integer.parseInt(search.getText());
				
					if(IssueDB.delete(book, key) == 1)
						l_name.setText("Book returned successfully!");
					else
						l_name.setText("No Book issued!");
				}
				public void clear() {
					l_name.setText(null);
				}
			});
			btnNewButton.setBounds(190, 150, 97, 35);
			returnbook.add(btnNewButton);
			
			
			
			JButton btnBack2 = new JButton("Back");
			btnBack2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LibChoice l= new LibChoice();
					l.frame.setVisible(true);
					frame.setVisible(false);
				}
			});
			btnBack2.setBounds(0, 394, 70, 23);
			returnbook.add(btnBack2);
			
			
			
			
			//////////////all Issued book //////////////////
					
			final JDesktopPane allissue = new JDesktopPane();
			allissue.setBackground(Color.WHITE);
			tabbedPane.addTab("All Issued Books", null, allissue, null);
			allissue.setLayout(null);
			
			final JLabel label_8 = new JLabel("");
			label_8.setBounds(20, 45, 645, 361);
			allissue.add(label_8);
			
			JButton btnDisplay = new JButton("Display");
			btnDisplay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String data[][]=null;
					String column[]=null;
					try{
						java.sql.Connection con= initDB.getConnection();
						java.sql.PreparedStatement ps=con.prepareStatement("select * from issue",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ResultSet rs=ps.executeQuery();
						
						java.sql.ResultSetMetaData rsmd=rs.getMetaData();
						int cols=rsmd.getColumnCount();
						column=new String[cols];
						for(int i=1;i<=cols;i++){
							column[i-1]=rsmd.getColumnName(i);
						}
						
						rs.last();
						int rows=rs.getRow();
						rs.beforeFirst();

						data=new String[rows][cols];
						int count=0;
						while(rs.next()){
							for(int i=1;i<=cols;i++){
								data[count][i-1]=rs.getString(i);
							}
							count++;
						}
						con.close();
					}catch(Exception e){System.out.println(e);}
					
					table = new JTable(data,column);
					//table.setBounds(10, 60, 500, 500);
					JScrollPane sp=new JScrollPane(table);
					table.setEnabled(false);
					sp.setBounds(10, 60, 721, 475);
					allissue.add(sp);
				}
			});
			btnDisplay.setBounds(10, 11, 89, 23);
			allissue.add(btnDisplay);
					
			JButton btnBack3 = new JButton("Back");
			btnBack3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LibChoice l= new LibChoice();
					l.frame.setVisible(true);
					frame.setVisible(false);
				}
			});
			btnBack3.setBounds(0, 394, 70, 23);
			allissue.add(btnBack3);
			
			
		}
}
