package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDB {
	
	public static int login(String u,String p) {
		int status= 0;
		String pass=null;
		try {
			Connection con=initDB.getConnection();
			PreparedStatement ps=con.prepareStatement("select password from admin where username = ?");
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
