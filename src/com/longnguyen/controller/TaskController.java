package com.longnguyen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.longnguyen.dao.TaskDAO;
import com.longnguyen.model.TaskModel;

@WebServlet("/admin-task")
public class TaskController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private TaskDAO taskDAO = null;
	
	public TaskController() {
		taskDAO = new TaskDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String task_id = req.getParameter("task_id");
		String alert = req.getParameter("alerts");
		
		if(task_id != null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			Gson gson = new Gson();
			String objectToReturn = "";
			
			TaskModel model = taskDAO.getById(Integer.parseInt(task_id));
			objectToReturn = gson.toJson(model);
			
			out.write(objectToReturn); //Đưa json trả về Ajax
			out.flush();
			return;
		}
		String group_id = req.getParameter("group_id");
		
		if(alert != null && alert.equals("success")) {
			req.setAttribute("alerts", "success");
			req.setAttribute("message", "Xóa thành công");
		} else if(alert != null && alert.equals("error")) {
			req.setAttribute("alerts", "danger");
			req.setAttribute("message", "Xóa thất bại");
		}
		
		req.getRequestDispatcher("views/admin/task/listTask.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		TaskModel model = new TaskModel();
		model.setName(req.getParameter("task_name"));
		model.setAccountId(Integer.parseInt(req.getParameter("account_id")));
		model.setGroupId(Integer.parseInt(req.getParameter("group_id")));
		model.setEndDate(req.getParameter("task_endDate"));
		model.setStatusId(Integer.parseInt(req.getParameter("status_id")));
		
		String task_id = req.getParameter("task_id");
		
		if (task_id != null && !task_id.isEmpty()) {
			model.setId(Integer.parseInt(task_id));
			if(taskDAO.upDate(model) > 0) {
				req.setAttribute("alerts", "success");
				req.setAttribute("message", "Update thành công");
			} else {
				req.setAttribute("alerts", "danger");
				req.setAttribute("message", "Update thất bại");
			}
			
		} else {
			if(taskDAO.inSert(model) > 0) {
				
				req.setAttribute("alerts", "success");
				req.setAttribute("message", "Thêm thành công");
			} else {
				req.setAttribute("alerts", "danger");
				req.setAttribute("message", "Thêm thất bại");
			}
		}
		req.getRequestDispatcher("views/admin/task/listTask.jsp").forward(req, resp);
	}

}
