package Classes;

import java.sql.*;

public class initDB {

	public static Connection getConnection(){
		Connection con=null;
		try{ 
		    Class.forName("com.mysql.jdbc.Driver");  
		    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library","root","");
		    
		  /*  PreparedStatement admin,book,librarian,issue,liblog;
		    
		    issue=con.prepareStatement("create table if not exists issue(s_name VARCHAR(20),s_roll INTEGER,b_name VARCHAR(20),date_of_issue DATE,s_id INTEGER)");
		    admin=con.prepareStatement("create table if not exists admin(username VARCHAR(20),passwords VARCHAR(20))");
		    book=con.prepareStatement("create table if not exists book(name VARCHAR(20),author VARCHAR(20), publication VARCHAR(20),quantity INTEGER(11))");
		    librarian=con.prepareStatement("create table if not exists librarian(name VARCHAR(20),id INTEGER PRIMARY KEY,address VARCHAR(20),contact INTEGER(10))");
		    liblog=con.prepareStatement("create table if not exists liblog(username VARCHAR(20),passwords VARCHAR(20))");
		    issue.execute();
		    admin.execute();
		    book.execute();
		    librarian.execute();
		    liblog.execute();*/
	    }catch(Exception e){ System.out.println(e);}
		return con;
	}
}
