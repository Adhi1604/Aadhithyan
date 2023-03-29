package com.besanttech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.besanttech.beans.Product;

public class ProductDao {

	public static void main(String[] args) {
		
	}
	static Connection con;
	public List<Product> getAllproducts() {
		List<Product> plist=new ArrayList<>();
		//database queries
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myshoppingstore","root","A@dhi#1998");
			String sql="select * from products";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
	
			while(rs.next()) {
			Product p=new Product();
			p.setProductid(rs.getInt(1));
			p.setProductname(rs.getString(2));
			p.setProductcolor(rs.getString(3));
			p.setProductprice(rs.getFloat(4));
			p.setProductquantity(rs.getInt(5));
			plist.add(p);
			    
			}
			return plist;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	public Product getById(int id) {
		try {
			Product pr=new Product();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myshoppingstore","root","ms1708");
			String sql1="select * from products where product_id=?";
			PreparedStatement ps=con.prepareStatement(sql1);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				pr.setProductid(rs.getInt(1));
				pr.setProductname(rs.getString(2));
				pr.setProductcolor(rs.getString(3));
				pr.setProductprice(rs.getFloat(4));
				pr.setProductquantity(rs.getInt(5));
			return pr;
		}
			}
		catch(Exception e){
			e.printStackTrace();
		}
      return null;
}
	}