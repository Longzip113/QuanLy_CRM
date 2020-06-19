package com.longnguyen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.longnguyen.connection.JDBCConnection;
import com.longnguyen.model.TaskModel;

public class TaskDAO {
	public ArrayList<TaskModel> findAll() {
		ArrayList<TaskModel> listTask = new ArrayList<TaskModel>();
		String sql = "SELECT * FROM TASKS";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement Statement = con.prepareStatement(sql);
			ResultSet resultSet = Statement.executeQuery();
			while (resultSet.next()) {
				TaskModel taskModel = new TaskModel();
				taskModel.setId(resultSet.getInt("STASK_ID"));
				taskModel.setName(resultSet.getString("STASK_NAME"));
				taskModel.setAccountId(resultSet.getInt("ACCOUNT_ID"));
				taskModel.setGroupId(resultSet.getInt("GROUP_ID"));
				taskModel.setStatusId(resultSet.getInt("STATUS_ID"));
				taskModel.setEndDate(resultSet.getString("END_DATE"));
				listTask.add(taskModel);
			}
			return listTask;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int inSert(TaskModel model) {
		String sql = "insert into TASKS(STASK_NAME, END_DATE, GROUP_ID, ACCOUNT_ID, STATUS_ID) values(?,?,?,?,?)";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setString(2, model.getEndDate());
			statement.setInt(3, model.getGroupId());
			statement.setInt(4, model.getAccountId());
			statement.setInt(5, model.getStatusId());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int upDate(TaskModel model) {
		String sql = "UPDATE TASKS SET STASK_NAME = ?, END_DATE = ?, GROUP_ID = ?, ACCOUNT_ID = ?, STATUS_ID = ? WHERE STASK_ID = ?";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setString(2, model.getEndDate());
			statement.setInt(3, model.getGroupId());
			statement.setInt(4, model.getAccountId());
			statement.setInt(5, model.getStatusId());
			statement.setInt(6, model.getId());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public TaskModel getById(int  id) {
		TaskModel taskModel = new TaskModel();
		String sql = "SELECT * FROM TASKS WHERE STASK_ID = ?";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				taskModel.setId(resultSet.getInt("STASK_ID"));
				taskModel.setName(resultSet.getString("STASK_NAME"));
				taskModel.setAccountId(resultSet.getInt("ACCOUNT_ID"));
				taskModel.setGroupId(resultSet.getInt("GROUP_ID"));
				taskModel.setStatusId(resultSet.getInt("STATUS_ID"));
				taskModel.setEndDate(resultSet.getString("END_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskModel;
		
	}
	
	public int delete(int id) {
		String sql = "DELETE FROM TASKS WHERE STASK_ID = ?";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
}
