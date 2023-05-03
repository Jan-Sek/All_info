package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class student {
	private Connection con;
	public student(){
		String dburl="jdbc:mysql://localhost:3306/program4";
		String dbuser="root";
		String dbpass="root";
		try {
			con=DriverManager.getConnection(dburl,dbuser,dbpass);
		}catch(SQLException e) {
			System.out.println("Server Error:"+e);
		}
	}
	//Login Code
			public boolean stlog(String stuname,String stupass) {
				boolean res=false;
			try {
		String query="select * from st_login where stusrname='"+stuname+"' and stpassword='"+stupass+"'";
				Statement smt=con.createStatement();
				ResultSet rs=smt.executeQuery(query);
				if(rs.next()) {
					res=true;
				}
				}catch(SQLException e) {
					System.out.println("Server error:"+e);	
				}return res;
			}
			//insert details code
			public int stinsert(String stname,String stemail,String st_state,String stpass) {
				int n=0;
				try {
String query="insert into stu_details(stname,stemail,st_state,stpassword)values(?,?,?,?)";
	PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, stname);
		pst.setString(2, stemail);
		pst.setString(3, st_state);
		pst.setString(4, stpass);
	n=pst.executeUpdate();
		}catch(SQLException e) {
					System.out.println("Server error"+e);
				}return n;
			}
			//insert register code
			public int stregister(String stuname1,String stpass1) {
				int n=0;
				try {
String query="insert into st_login(stusrname,stpassword)values(?,?)";
	PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, stuname1);
		pst.setString(2, stpass1);
	n=pst.executeUpdate();
		}catch(SQLException e) {
					System.out.println("Server error"+e);
				}return n;
			}
			
			//insert select code
			public void stselect() {
				try {
				String query="select * from students";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
			while(rs.next()) {
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getFloat(6));
			}System.out.println("End of the Statement");
				}catch(SQLException e) {
					System.out.println("Server error:"+e);
				}
		}
	

}
		

