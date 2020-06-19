package com.longnguyen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.longnguyen.dao.AccountDAO;
import com.longnguyen.model.AccountModel;

@WebServlet("/admin-account")
public class AccountController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private AccountDAO accountDAO = null;
	
	public AccountController() {
		accountDAO = new AccountDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account_id = req.getParameter("account_id");
		String action = req.getParameter("action");
		String alert = req.getParameter("alerts");
		
		if(account_id != null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			Gson gson = new Gson();
			String objectToReturn = "";
			if(action.equals("edit")) { // cap nhat
				AccountModel model = accountDAO.getById(Integer.parseInt(account_id));
				
				objectToReturn = gson.toJson(model);
				
			} else { // Xoa
				if (accountDAO.delete(Integer.parseInt(account_id)) > 0) {
					objectToReturn = gson.toJson("success");
				} else {
					objectToReturn = gson.toJson("error");
				}
			}
			out.write(objectToReturn); //Đưa json trả về Ajax
			out.flush();
			return;
		}
		if(alert != null && alert.equals("success")) {
			req.setAttribute("alerts", "success");
			req.setAttribute("message", "Xóa thành công");
		} else if(alert != null && alert.equals("error")) {
			req.setAttribute("alerts", "danger");
			req.setAttribute("message", "Xóa thất bại");
		}
		
		req.setAttribute("account", accountDAO.findAll());
		req.getRequestDispatcher("views/admin/account/listAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		AccountModel model = new AccountModel();
		model.setEmail(req.getParameter("email"));
		model.setFullName(req.getParameter("fullname"));
		model.setPassword(req.getParameter("password"));
		model.setPhone(req.getParameter("phone"));
		model.setAddRess(req.getParameter("address"));
		
		String account_id = req.getParameter("account_id");
		
		if (account_id != null && !account_id.isEmpty()) {
			model.setId(Integer.parseInt(account_id));
			if(accountDAO.upDate(model) > 0) {
				req.setAttribute("alerts", "success");
				req.setAttribute("message", "Update thành công");
			} else {
				req.setAttribute("alerts", "danger");
				req.setAttribute("message", "Update thất bại");
			}
			
		} else {
			if(accountDAO.inSert(model) > 0) {
				
				req.setAttribute("alerts", "success");
				req.setAttribute("message", "Thêm thành công");
			} else {
				req.setAttribute("alerts", "danger");
				req.setAttribute("message", "Thêm thất bại");
			}
		}
		req.setAttribute("account", accountDAO.findAll());
		req.getRequestDispatcher("views/admin/account/listAccount.jsp").forward(req, resp);
	}

}
