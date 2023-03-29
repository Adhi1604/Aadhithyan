package com.besanttech.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besanttech.dao.ProductDao;
@WebServlet("/products")
public class ProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		ProductDao pd=new ProductDao();
		req.setAttribute("products",pd.getAllproducts());
		RequestDispatcher rd=req.getRequestDispatcher("views/products.jsp");
		rd.forward(req, res);
		
	}

}