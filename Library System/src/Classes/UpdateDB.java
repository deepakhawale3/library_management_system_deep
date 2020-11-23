package Classes;
import java.sql.*;
import java.sql.Connection;
public class UpdateDB {



public static int save(int id, String nm, String addr, long cont) {
	// TODO Auto-generated method stub
	int status =0;
	try {
	Connection con=initDB.getConnection();
	String s="update librarian set name= ? ,address=?,contact=? where id= ?";
	PreparedStatement ps=con.prepareStatement(s);
	
	
	ps.setString(1,nm);
	ps.setString(2,addr);
	ps.setLong(3,cont);
	ps.setInt(4,id);
	
	
	
	if(ps.execute())
		status=1;
		System.out.println(status);
	}
	catch(Exception f) {System.out.println(f);}
	return status;
}



public static int book(String nm, String author, String publication, int quantity) {
	// TODO Auto-generated method stub
	int status =0;
	try {
	Connection con=initDB.getConnection();
	String s="update book set author= ? ,publication=?,quantity=? where name= ?";
	PreparedStatement ps=con.prepareStatement(s);
	
	
	
	ps.setString(1,author);
	ps.setString(2,publication);
	ps.setInt(3,quantity);
	ps.setString(4,nm);
	
	
	
	if(ps.execute())
		status=1;
		System.out.println(status);
	}
	catch(Exception f) {System.out.println(f);}
	return status;
}
}
