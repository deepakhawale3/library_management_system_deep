package Frames;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import Classes.AdminDB;
import Classes.LibDB;
import Classes.LiblogDB;
import Classes.UpdateDB;
import Classes.initDB;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;


public class Admin_Page {

	protected static final boolean NumberFormatException = false;
	JFrame frame;
	static Admin_Page admin_page;
	private JTable table;
	private JTextField lname;
	private JTextField lid;
	private JTextField ladd;
	private JTextField lcon;
	private JTextField user;
	private JTextField pass;
	private JTextField did;
	private JTextField u_id;
	private JTextField u_name;
	private JTextField u_add;
	private JTextField u_con;
	private JTextField u_u;
	private JTextField u_p;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_page = new Admin_Page();
					admin_page.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(46, 139, 87));
		frame.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		frame.setForeground(new Color(218, 112, 214));
		frame.setTitle("Library Management System");
		frame.setBounds(100, 100, 718, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 6, 702, 464);
		frame.getContentPane().add(tabbedPane);
		
		
		
		//////////// add librarian /////////
		
		
		JDesktopPane addlibrarian = new JDesktopPane();
		addlibrarian.setBackground(Color.WHITE);
		tabbedPane.addTab("Add Libraran", null, addlibrarian, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		
		lname = new JTextField();
		lname.setBackground(Color.WHITE);
		lname.setBounds(303, 21, 178, 35);
		addlibrarian.add(lname);
		lname.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(141, 19, 118, 35);
		addlibrarian.add(lblName);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(141, 65, 118, 35);
		addlibrarian.add(lblId);
		
		lid = new JTextField();
		lid.setColumns(10);
		lid.setBackground(Color.WHITE);
		lid.setBounds(303, 67, 178, 35);
		addlibrarian.add(lid);
		
		lid.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(141, 111, 118, 35);
		addlibrarian.add(lblAddress);
		
		ladd = new JTextField();
		ladd.setColumns(10);
		ladd.setBackground(Color.WHITE);
		ladd.setBounds(303, 113, 178, 35);
		addlibrarian.add(ladd);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContact.setBounds(141, 157, 118, 35);
		addlibrarian.add(lblContact);
		
		lcon = new JTextField();
		lcon.setColumns(10);
		lcon.setBackground(Color.WHITE);
		lcon.setBounds(303, 159, 178, 35);
		addlibrarian.add(lcon);
		
		lcon.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		lcon.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            if (lcon.getText().length() == 10) {
	                e.consume();
	            }
	        }
	    });
		final JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(141, 391, 340, 23);
		addlibrarian.add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(141, 203, 118, 35);
		addlibrarian.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(141, 249, 118, 35);
		addlibrarian.add(lblPassword);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBackground(Color.WHITE);
		user.setBounds(303, 205, 178, 35);
		addlibrarian.add(user);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBackground(Color.WHITE);
		pass.setBounds(303, 251, 178, 35);
		addlibrarian.add(pass);
		
		
		JButton addLib = new JButton("Submit");
		
		addLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nm = lname.getText().trim();
				int id = Integer.parseInt(lid.getText());
				String addr = ladd.getText().trim();
				long cont = Long.parseLong(lcon.getText());
				String username = user.getText();
				String password = pass.getText();
				
				if(LibDB.save(nm, id, addr, cont)  == 1 && LiblogDB.save(username, password) == 1) {
					label.setText("Librarian Added successfully!");
					clear();
				}else {
					label.setText("Librarian Adding Failed!");
					clear();
				}
			}

			public void clear() {
				lname.setText(null);
				ladd.setText(null);
				lid.setText(null);
				lcon.setText(null);
				user.setText(null);
				pass.setText(null);
			}
		});
		addLib.setBounds(234, 333, 130, 47);
		addlibrarian.add(addLib);
		
		
		
		
		
		
		///////// delete librarian ///////////
		
		
		
		JDesktopPane delete = new JDesktopPane();
		delete.setBackground(Color.WHITE);
		tabbedPane.addTab("Delete Librarian", null, delete, null);
		
		did = new JTextField();
		did.setBounds(232, 37, 177, 42);
		delete.add(did);
		did.setColumns(10);
		
		did.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		JLabel lblNewLabel = new JLabel("Enter id to delete");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(68, 44, 154, 28);
		delete.add(lblNewLabel);
		
		JLabel lblNew = new JLabel("It accepts numbers only");
		lblNew.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNew.setBounds(200, 80, 154, 28);
		delete.add(lblNew);
		
		
		JButton del = new JButton("Delete");
		
		final JLabel label_1 = new JLabel("");
		label_1.setBounds(68, 168, 372, 48);
		delete.add(label_1);
		
		
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(did.getText());
				
				if(LibDB.del(id) == 1) {
					label_1.setText("Librarian deleted successfully!");
				}
				else
				
				
					label_1.setText("Librarian does not exists!");
				
				
				
			clear();
			}
			public void clear() {
				did.setText(null);
			}
			
		});
		del.setBounds(174, 109, 100, 36);
		delete.add(del);
		
		
		
		
		
		///////// update librarian ////////////////
		
		JDesktopPane Updatepane = new JDesktopPane();
		Updatepane.setBackground(Color.WHITE);
		tabbedPane.addTab("Update Librarian", null, Updatepane, null);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(153, 72, 118, 35);
		Updatepane.add(label_2);
		
		u_id = new JTextField();
		u_id.setColumns(10);
		u_id.setBackground(Color.WHITE);
		u_id.setBounds(315, 28, 178, 35);
		Updatepane.add(u_id);
		
		u_id.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		u_name = new JTextField();
		u_name.setEnabled(false);
		
		u_name.setColumns(10);
		u_name.setBackground(Color.WHITE);
		u_name.setBounds(315, 74, 178, 35);
		Updatepane.add(u_name);
		
		JLabel label_4 = new JLabel("Address");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(153, 118, 118, 35);
		Updatepane.add(label_4);
		
		u_add = new JTextField();
		u_add.setEnabled(false);
		u_add.setColumns(10);
		u_add.setBackground(Color.WHITE);
		u_add.setBounds(315, 120, 178, 35);
		Updatepane.add(u_add);
		
		u_con = new JTextField();
		u_con.setEnabled(false);
		u_con.setColumns(10);
		u_con.setBackground(Color.WHITE);
		u_con.setBounds(315, 166, 178, 35);
		Updatepane.add(u_con);
		u_con.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            if (u_con.getText().length() == 10) {
	                e.consume();
	            }
	        }
	    });
		u_con.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	              }
	         }
	       });
		
		
		
		JLabel label_7 = new JLabel("Contact");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(153, 164, 118, 35);
		Updatepane.add(label_7);
		
		final JLabel label_3 = new JLabel("");
		label_3.setBounds(119, 398, 408, 27);
		Updatepane.add(label_3);
		
		final JLabel label_3a = new JLabel("");
		label_3a.setBounds(500, 198, 408, 27);
		Updatepane.add(label_3a);
		
		
		JButton update = new JButton("Update");
		
		update.setBounds(246, 340, 130, 47);
		Updatepane.add(update);
		
		JButton check = new JButton("Check");
		check.setBounds(500, 25, 100, 47);
		Updatepane.add(check);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				int id = Integer.parseInt(u_id.getText());
			
				try {
					java.sql.Connection con= initDB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select name,address,contact from librarian where id = '" + id + "'");
					ResultSet rs=ps.executeQuery();
					rs.next();
					if(rs != null) {
							u_name.setText(rs.getString("name"));
							u_add.setText(rs.getString("address"));
							u_con.setText(rs.getString("contact"));
							
							u_name.setEnabled(true);
							u_add.setEnabled(true);
							u_con.setEnabled(true);
							
							

							
					}
				}catch(Exception e) {
					label_3.setText("Librarian does not exists!");
					u_name.setEnabled(false);
					u_add.setEnabled(false);
					u_con.setEnabled(false);
					
					label_3a.setEnabled(false);
				
			}
				

			}
			
		});
		
		JLabel lblEnterIdTo = new JLabel("Enter id to update");
		lblEnterIdTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterIdTo.setBounds(153, 26, 130, 35);
		Updatepane.add(lblEnterIdTo);
		
		
		
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(u_id.getText());				
					String nm = u_name.getText();
					String addr = u_add.getText();
					long cont = Long.parseLong(u_con.getText());
					
					
					if(UpdateDB.save(id,nm, addr, cont)  == 0 ) {
						label_3.setText("Librarian updated successfully!");
					}
				
				else
					label_3.setText("Librarian  not Updated!");
				clear();
			}
			public void clear() {
				u_id.setText(null);
				u_name.setText(null);
				u_add.setText(null);
				u_con.setText(null);
			
			}
		});
		
		
		
		
		/////////// all librarian//////////
		
		final JDesktopPane librarian = new JDesktopPane();
		librarian.setBackground(Color.WHITE);
		tabbedPane.addTab("All Librarians", null, librarian, null);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data[][]=null;
				String column[]=null;
				try{
					java.sql.Connection con= initDB.getConnection();
					java.sql.PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
				//table.setBounds(10, 50, 400, 400);
				//desktopPane_4.add(table);
				JScrollPane sp=new JScrollPane(table);
				table.setEnabled(false);
				sp.setBounds(10, 60, 721, 475);
				librarian.add(sp);
			}
		});
		btnDisplay.setBounds(10, 11, 89, 23);
		librarian.add(btnDisplay);
		
		JButton btnBack4 = new JButton("Back");
		btnBack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn a=new LogIn();
				a.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack4.setBounds(0, 413, 89, 23);
		librarian.add(btnBack4);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn a=new LogIn();
				a.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(0, 413, 89, 23);
		addlibrarian.add(btnBack);
		
		JButton btnBack3 = new JButton("Back");
		btnBack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn a=new LogIn();
				a.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack3.setBounds(0, 413, 89, 23);
		Updatepane.add(btnBack3);
		
		JButton btnBack2 = new JButton("Back");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn a=new LogIn();
				a.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack2.setBounds(0, 413, 89, 23);
		delete.add(btnBack2);
	}
}
