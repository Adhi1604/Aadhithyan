package com.besanttech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.besanttech.beans.User;

public class UserDao {

	public static void main(String[] args) {
		
	}

	static Connection con;
	public User validatelogin(User user) {
		
		//database queries
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myshoppingstore","root","A@dhi#1998");
			String sql="select * from users where user_name=? and user_pwd=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				return user;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}