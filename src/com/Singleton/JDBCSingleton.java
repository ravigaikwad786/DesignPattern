package com.Singleton;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSingleton {
	
	private static JDBCSingleton jdbc;
	
	private JDBCSingleton() {
		
	}
	
	public static JDBCSingleton getInstance() {
		if(jdbc==null) {
			jdbc=new JDBCSingleton();
		}
		return jdbc;
				
	}
	
	private static Connection geConnectiont() throws ClassNotFoundException , SQLException {
		Connection con ;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","");
		return con;
		
	}
	
	public int insert(String name , String password) throws SQLException{
		
		Connection c=null;
		PreparedStatement ps = null;
		int recordCounter=0;
		
		try {
			c=this.geConnectiont();
			ps=c.prepareStatement("insert into singleDP(uname,password)values(?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			recordCounter=ps.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				ps.close();
			}
			if(c!=null) {
				c.close();
			}
		}
		
		return recordCounter;
		
	}
	
	public void view(String uname)throws IOException ,SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=this.geConnectiont();
			ps=con.prepareStatement("select * from singleDP where uname=?");
			ps.setString(1, uname);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Name="+rs.getString(2)+"Password="+rs.getString(3));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(rs!=null){  
                rs.close();  
            }if (ps!=null){  
              ps.close();  
          }if(con!=null){  
              con.close();  
          }   
		}
		   
	}
	public int delete(int uid) throws IOException ,SQLException {
		
		Connection c=null;
		PreparedStatement ps = null;
		int recordCounter=0;
		
		try {
			c=this.geConnectiont();
			ps=c.prepareStatement("delete from singleDP where uid=?");
			ps.setInt(1,uid);
			recordCounter=ps.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				ps.close();
			}
			if(c!=null) {
				c.close();
			}
		}
		return recordCounter;
	}
	
	public int CheckId(int uid) throws SQLException{
		
		Connection c=null;
		PreparedStatement ps=null;
		int count=0;
		try {
			c=jdbc.geConnectiont();
			ps=c.prepareStatement("select * from singleDP where uid='"+uid+"'");
			ResultSet rs=ps.executeQuery();
			count=rs.getInt(1);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				ps.close();
			}
			if(c!=null) {
				c.close();
			}
		}
				
		
		return count;
	}
	
	public int update(int uid,String name,String pass) throws SQLException{
		Connection c=null;
		PreparedStatement ps=null;
		int count=0;
				try {
					c=jdbc.geConnectiont();
					ps=c.prepareStatement("update singleDP uname=? and pass=? where uid=?");
					ps.setString(1, name);
					ps.setString(2, pass);
					ps.setInt(3, uid);
					count=ps.executeUpdate();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				finally {
					if(ps!=null) {
						ps.close();
					}
					if(c!=null) {
						c.close();
					}
				}
				return count;

	}
				
}
