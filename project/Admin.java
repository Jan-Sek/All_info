package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {
	private Connection con;
	public Admin(){
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
	public boolean adlog(String uname,String upass) {
		boolean res=false;
	try {
String query="select * from student_login where username='"+uname+"' and password='"+upass+"'";
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		if(rs.next()) {
			res=true;
		}
		}catch(SQLException e) {
			System.out.println("Server error:"+e);	
		}return res;
	}
		//Insert Code 
	public int insert(String name,String email,float mark) {
		int n=0;
		try {
			String query="insert into students(sname,email,smark)values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2, email);
			pst.setFloat(3, mark);
			n=pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Server error"+e);
		}return n;
	}
		
		//Select Code
	public void select() {
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
		//Update Code
	public int update(String email,String pass,int id) {
		int n=0;
		try {
	String query="update students set password=? where email=? and sid=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, pass);
			pst.setString(2,email);
			pst.setInt(3,id);
			n=pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Server error:"+e);
		}return n;
	}
	
		//Delete 
	public int delete(int id) {
		int n=0;
		try {
			String query="delete from students where sid=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1, id);
			n=pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Server error"+e);
		}return n;
	}
		
	}


