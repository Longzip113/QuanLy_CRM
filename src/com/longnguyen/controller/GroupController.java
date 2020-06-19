package com.longnguyen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.longnguyen.dao.GroupDAO;
import com.longnguyen.model.GroupModel;

@WebServlet("/admin-group")
public class GroupController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private GroupDAO groupDAO;
	
	public GroupController() {
		groupDAO = new GroupDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group_id = req.getParameter("group_id");
		String action = req.getParameter("action");
		String alert = req.getParameter("alerts");
		
		if(group_id != null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			Gson gson = new Gson();
			String objectToReturn = "";
			if(action.equals("edit")) { // cap nhat
				GroupModel model = groupDAO.getById(Integer.parseInt(group_id));
				
				objectToReturn = gson.toJson(model);
				
			} else { // Xoa
				if (groupDAO.delete(Integer.parseInt(group_id)) > 0) {
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
		
		req.setAttribute("group", groupDAO.findAll());
		req.getRequestDispatcher("views/admin/group/listGroup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		GroupModel model = new GroupModel();
		model.setName(req.getParameter("group_name"));
		model.setDescription(req.getParameter("description"));
		
		String group_id = req.getParameter("group_id");
		
		if (group_id != null && !group_id.isEmpty()) {
			model.setId(Integer.parseInt(group_id));
			if(groupDAO.upDate(model) > 0) {
				req.setAttribute("alerts", "success");
				req.setAttribute("message", "Update thành công");
			} else {
				req.setAttribute("alerts", "danger");
				req.setAttribute("message", "Update thất bại");
			}
			
		} else {
			if(groupDAO.inSert(model) > 0) {
				
				req.setAttribute("alerts", "success");
				req.setAttribute("message", "Thêm thành công");
			} else {
				req.setAttribute("alerts", "danger");
				req.setAttribute("message", "Thêm thất bại");
			}
		}
		req.setAttribute("group", groupDAO.findAll());
		req.getRequestDispatcher("views/admin/group/listGroup.jsp").forward(req, resp);
	}
	

}
