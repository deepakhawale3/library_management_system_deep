package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LiblogDB {

	public static int save(String a,String b) {
		int status= 0;
		try {
		Connection con=initDB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into liblog values(?,?)");
		ps.setString(1,a);
		ps.setString(2,b);
		status=ps.executeUpdate();
		}
		catch(Exception e) {System.out.println("primary key");}
		return status;
		
		
	}



public static int login(String u,String p) {
	int status= 0;
	String pass=null;
	try {
		Connection con=initDB.getConnection();
		PreparedStatement ps=con.prepareStatement("select password from liblog where username = ?");
		ps.setString(1,u);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			pass=rs.getString("password");
		
		if(pass.equals(p))
			status=1;
	}
		catch(Exception e) {System.out.println(e);}
	return status;
}
}