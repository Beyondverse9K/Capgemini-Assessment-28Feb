package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc1 {

	public Jdbc1() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.print("Enter ID ");
		int id = sc.nextInt();
		String na=sc.nextLine();
		String em=sc.nextLine();
		String url="jdbc:mysql://localhost:3306/jdbc1";
		String user="root";
		String pass="mysql";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,user,pass);
		ps=con.prepareStatement("UPDATE STUDENT SET NAME = ?, EMAIL = ? WHERE ID = ?");
		ps.setString(1, na);
		ps.setString(2, em);
		ps.setInt(3,id);
		rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}	
	}
}
