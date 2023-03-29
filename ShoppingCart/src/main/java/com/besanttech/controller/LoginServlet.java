package com.besanttech.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besanttech.beans.User;
import com.besanttech.dao.UserDao;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		User user=new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("userpass"));
		UserDao ud=new UserDao();
		if(ud.validatelogin(user)==null) {
			out.println("Incorrect username or password");
			RequestDispatcher rd=req.getRequestDispatcher("views/login.jsp");
			rd.include(req, res);
		}
		else {
			out.println("Login successfull");
			HttpSession ses=req.getSession();
			ses.setAttribute("username",user.getUsername());
			req.getRequestDispatcher("views/home.jsp").forward(req, res);
		}
	}
	
	}