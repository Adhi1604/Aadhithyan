package com.besanttech.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.besanttech.beans.Order;
import com.besanttech.beans.Product;
import com.besanttech.dao.OrderDao;

@WebServlet("/orders")
public class LogoutServlet extends HttpServlet{
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			OrderDao orderDao = new OrderDao();
			HttpSession session = request.getSession(false);
			String username = (String) session.getAttribute("username");
			List<Order> orderList = orderDao.getUserOrders(username);
			session.setAttribute("orderList", orderList);
			RequestDispatcher rd = request.getRequestDispatcher("views/order.jsp");
			rd.forward(request, response);
		}

		else if (action.equals("buy")) {
			OrderDao order = new OrderDao();
			HttpSession session = request.getSession(false);
			List<Product> products = (List<Product>) session.getAttribute("cartProducts");
			order.insertOrder(products, (String) session.getAttribute("username"));
			session.setAttribute("cartProducts", new ArrayList<Product>());
			session.setAttribute("Total", 0);
			RequestDispatcher rd = request.getRequestDispatcher("views/cart.jsp");
			rd.forward(request, response);
		}

	}



}