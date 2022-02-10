import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Dbdata 
{ 
	Connection con;
	Dbdata()
	{
		String url = "jdbc:mysql://localhost:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false";
	    String user = "John";
	    String password = "john123";
	    //String Q1 ="DROP TABLE IF EXISTS Dailydiary";
	    //String Q2="CREATE TABLE Dailydiary(Date VARCHAR(12) , Time VARCHAR(16) PRIMARY KEY,File VARCHAR(5000))";
	    try 
	    {
	    	con = DriverManager.getConnection(url, user, password);
	    	/*PreparedStatement pst = con.prepareStatement(Q1);
	    	pst.execute(Q1);
	    	pst.execute(Q2);*/
	    }
	    catch(SQLException ex)
	    {
	    	Logger lgr = Logger.getLogger(Dbdata.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
	    }
	}
	void insert(String dat,String tim,String text)
	{
		String sql = "INSERT INTO Dailydiary(Date ,Time ,File) VALUES(?,?,?)";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,dat);
			pst.setString(2,tim);
			pst.setString(3,text);
			System.out.println(pst.executeUpdate());
			System.out.println("A new diary has been inserted");
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getStackTrace());
		}
	}
	String allrecords()
	{
		String rest="";
		String sql = "Select * from Dailydiary";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while (rs.next())
			{
				rest=rest+"\n"+rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n";
			}
			System.out.println(rest);
		}
		catch (SQLException ex) 
		{
	    	 Logger lgr = Logger.getLogger(Dbdata.class.getName());
	         lgr.log(Level.SEVERE, ex.getMessage(), ex);
	    }
		return rest;
	}
	String searchdate(String da)
	{
		String rese="";
		String sql = "Select * from Dailydiary where Date like '%"+da+ "%'";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				rese=rese+"\n"+rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n";
			}
			System.out.println(rese);
		}
		catch (SQLException ex)
		{
	    	 Logger lgr = Logger.getLogger(Dbdata.class.getName());
	         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return rese;
	}
	String searchword(String wo)
	{
		String rese="";
		String sql = "SELECT * FROM Dailydiary WHERE File like '%"+wo+"%'";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				rese=rese+"\n"+rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n";
			}
			System.out.println(rese);
		}
		catch (SQLException ex)
		{
	    	 Logger lgr = Logger.getLogger(Dbdata.class.getName());
	         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return rese;
	}
	String searchtime(String ti)
	{
		String rese="";
		String sql = "SELECT * FROM Dailydiary WHERE Time like '%"+ti+"%'";
		try
		{
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				rese=rese+"\n"+rs.getString(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n";
			}
			System.out.println(rese);
		}
		catch (SQLException ex)
		{
	    	 Logger lgr = Logger.getLogger(Dbdata.class.getName());
	         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return rese;
	}
}