package com.longnguyen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.longnguyen.connection.JDBCConnection;
import com.longnguyen.model.AccountModel;

public class AccountDAO {
	
	public ArrayList<AccountModel> findAll() {
		ArrayList<AccountModel> listAccount = new ArrayList<AccountModel>();
		String sql = "SELECT * FROM ACCOUNTS";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement Statement = con.prepareStatement(sql);
			ResultSet resultSet = Statement.executeQuery();
			while (resultSet.next()) {
				AccountModel accountModel = new AccountModel();
				accountModel.setId(resultSet.getInt("ACCOUNT_ID"));
				accountModel.setFullName(resultSet.getString("FULLNAME"));
				accountModel.setEmail(resultSet.getString("EMAIL"));
				accountModel.setPassword(resultSet.getString("PASSWORD"));
				accountModel.setAddRess(resultSet.getString("ADDRESS"));
				accountModel.setPhone(resultSet.getString("PHONE"));
				listAccount.add(accountModel);
			}
			return listAccount;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int inSert(AccountModel model) {
		String sql = "insert into ACCOUNTS(FULLNAME,EMAIL,PASSWORD, ADDRESS, PHONE) values(?,?,?,?,?)";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, model.getFullName());
			statement.setString(2, model.getEmail());
			statement.setString(3, model.getPassword());
			statement.setString(4, model.getAddRess());
			statement.setString(5, model.getPhone());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int upDate(AccountModel model) {
		String sql = "UPDATE ACCOUNTS SET FULLNAME = ?,EMAIL = ?, ADDRESS = ?, PHONE = ? WHERE ACCOUNT_ID = ?";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, model.getFullName());
			statement.setString(2, model.getEmail());
			statement.setString(3, model.getAddRess());
			statement.setString(4, model.getPhone());
			statement.setInt(5, model.getId());
			
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public AccountModel getById(int  id) {
		AccountModel accountModel = new AccountModel();
		String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
		try {
			Connection con = JDBCConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				accountModel.setId(resultSet.getInt("ACCOUNT_ID"));
				accountModel.setFullName(resultSet.getString("FULLNAME"));
				accountModel.setEmail(resultSet.getString("EMAIL"));
				accountModel.setPassword(resultSet.getString("PASSWORD"));
				accountModel.setAddRess(resultSet.getString("ADDRESS"));
				accountModel.setPhone(resultSet.getString("PHONE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountModel;
		
	}
	
	public int delete(int id) {
		String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
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
