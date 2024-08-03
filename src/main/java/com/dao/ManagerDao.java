package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ManagerDao {

	Connection c;
	
	public ManagerDao() {
		this.c = new DbConnectivity().getConnection();
	}
	
	public String managerLogin(String name, String password) {
		try {
			
			PreparedStatement ps=c.prepareStatement("select * from manager where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString("name");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String,Long> weeklyDetails(String name){
		try {
			
			Map<String,Long> m=new HashMap<>();
			
			String query="SELECT task, SUM(time_to_sec(duration)) AS total_duration " +
	                   "FROM task_details WHERE `name` = ? " +
	                   "AND YEAR(`date`) = YEAR(CURDATE()) " +
	                   "AND WEEK(`date`, 1) = WEEK(CURDATE(), 1) " +
	                   "GROUP BY task";
			
			System.out.println(name);
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				m.put(rs.getString("task"), Long.parseLong(rs.getString("total_duration")));
			}
			System.out.println(m.keySet());
			System.out.println(m.values());
			return m;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String,Long> monthlyDetails(String name){
		try {
			
			Map<String,Long> m=new HashMap<>();
			
			String query="SELECT task, SUM(time_to_sec(duration)) AS total_duration " +
	                   "FROM task_details WHERE `name` = ? " +
	                   "AND YEAR(`date`) = YEAR(CURDATE()) " +
	                   "AND Month(`date`) = Month(CURDATE()) " +
	                   "GROUP BY task";
			
			System.out.println(name);
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				m.put(rs.getString("task"), Long.parseLong(rs.getString("total_duration")));
			}
			System.out.println(m.keySet());
			System.out.println(m.values());
			return m;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void addManager(String id , String name, String password) {
		try {
			PreparedStatement ps=c.prepareStatement("insert into manager values(?,?,?)");
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
	
	
	public void deleteManager(String name) {
		try {
			PreparedStatement ps=c.prepareStatement("delete from manager where name=?;");
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
