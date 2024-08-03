package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.TaskDetails;

public class EmployeeDao {

	Connection c;
	boolean login = false;

	public boolean isLogin() {
		return login;
	}

	public EmployeeDao() {
		this.c = new DbConnectivity().getConnection();
	}

	public List<TaskDetails> login(String userName, String password) throws SQLException {

		try {
			PreparedStatement ps = c.prepareStatement("Select * from employee where name=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				List<TaskDetails> l = new TaskDetailsDao().getTasks( userName);
				this.login = true;
				return l;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	
	
	
	
	
	
	

	
	
	public void addEmployee(String id , String name, String password) {
		try {
			PreparedStatement ps=c.prepareStatement("insert into employee values(?,?,?);");
			ps.setString(1,id);
			ps.setString(2, name);
			ps.setString(3, password);
			int k=ps.executeUpdate();
			if(k!=1) {
				System.out.println("not inserted");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(String name) {
		try {
			PreparedStatement ps=c.prepareStatement("delete from employee where name=?;");
			ps.setString(1, name);
			int k=ps.executeUpdate();
			if(k!=1) {
				System.out.println("not deleted");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
