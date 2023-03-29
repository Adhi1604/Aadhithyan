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

import com.besanttech.beans.Product;
import com.besanttech.dao.ProductDao;
@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String action = req.getParameter("action");
		if (action == null) {
			req.getRequestDispatcher("views/cart.jsp").forward(req, res);
		} else if (action.equals("add")) {
			HttpSession session = req.getSession(false);
			List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
			if (cartProducts == null) {
				cartProducts = new ArrayList<>();
			}
			ProductDao productDao = new ProductDao();
			Product product = productDao.getById(Integer.parseInt(req.getParameter("product_id")));
			if (product != null) {
				cartProducts.add(product);
				session.setAttribute("cartProducts", cartProducts);
				updateCartPrice(cartProducts,session);
			}
			
			
			RequestDispatcher rd = req.getRequestDispatcher("views/cart.jsp");
			rd.forward(req, res);

		} else if (action.equals("remove")) {
			HttpSession session = req.getSession(false);
			List<Product> cartProducts = (List<Product>) session.getAttribute("cartProducts");
			for (Product product : cartProducts) {
				if (product.getProductid() == Integer.parseInt(req.getParameter("product_id"))) {
					cartProducts.remove(product);
					session.setAttribute("cartProducts", cartProducts);
					updateCartPrice(cartProducts,session);
					break;
				}
			}

			RequestDispatcher rd = req.getRequestDispatcher("views/cart.jsp");
			rd.forward(req, res);
		}
	}
	
	public void updateCartPrice(List<Product> cartProducts, HttpSession session) {
		float price =0;
		for(Product product: cartProducts) {
			price = (float) (price + product.getProductprice());
		}
	
		session.setAttribute("Total", price);
	}

}