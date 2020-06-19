package com.longnguyen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.longnguyen.connection.JDBCConnection;
import com.longnguyen.model.GroupModel;

public class GroupDAO {

	public ArrayList<GroupModel> findAll() {
			ArrayList<GroupModel> listGroup = new ArrayList<GroupModel>();
			String sql = "SELECT * FROM GROUPSS";
			try {
				Connection con = JDBCConnection.getConnection();
				PreparedStatement Statement = con.prepareStatement(sql);
				ResultSet resultSet = Statement.executeQuery();
				while (resultSet.next()) {
					GroupModel groupModel = new GroupModel();
					groupModel.setId(resultSet.getInt("GROUP_ID"));
					groupModel.setName(resultSet.getString("GROUP_NAME"));
					groupModel.setDescription(resultSet.getString("DESCRIPTION"));
					listGroup.add(groupModel);
				}
				return listGroup;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
		public int inSert(GroupModel model) {
			String sql = "insert into GROUPSS(GROUP_NAME,DESCRIPTION) values(?,?)";
			try {
				Connection con = JDBCConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, model.getName());
				statement.setString(2, model.getDescription());
				
				return statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
			
		}
		
		public int upDate(GroupModel model) {
			String sql = "UPDATE GROUPSS SET GROUP_NAME = ?,DESCRIPTION = ? WHERE GROUP_ID = ?";
			try {
				Connection con = JDBCConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, model.getName());
				statement.setString(2, model.getDescription());
				statement.setInt(3, model.getId());
				
				return statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
			
		}
		
		public GroupModel getById(int  id) {
			GroupModel groupModel = new GroupModel();
			String sql = "SELECT * FROM GROUPSS WHERE GROUP_ID = ?";
			try {
				Connection con = JDBCConnection.getConnection();
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					groupModel.setId(resultSet.getInt("GROUP_ID"));
					groupModel.setName(resultSet.getString("GROUP_NAME"));
					groupModel.setDescription(resultSet.getString("DESCRIPTION"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return groupModel;
			
		}
		
		public int delete(int id) {
			String sql = "DELETE FROM GROUPSS WHERE GROUP_ID = ?";
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
