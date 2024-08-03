package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.TaskDetails;

public class TaskDetailsDao {
	
	private Connection c;
	
	public TaskDetailsDao() {
		this.c=new DbConnectivity().getConnection();
	}

	public List<TaskDetails> getTasks(String userName) throws SQLException {
		List<TaskDetails> l=new ArrayList<>();
		try {
			PreparedStatement ps=c.prepareStatement("select * from task_details where `name`=\""+userName+"\"");
			ResultSet  rs=ps.executeQuery();
			
			
			while(rs.next()) {
				l.add(this.fitIntoTaskDetails(rs));
			}
			
			System.out.println(l);
			return l;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void deleteTask(String name,String task, String date) throws SQLException {
		try {
			
			
			PreparedStatement ps=c.prepareStatement("delete from task_details where `task`=? and `date`=? and `name`=?");
			ps.setString(1, task);
			ps.setString(2, date);
			ps.setString(3, name);
			
			System.out.println(task);
			System.out.println(date);
			System.out.println(name);
			
			int k=ps.executeUpdate();
			if(k==1) {
				System.out.println("deleted");
			}else {
				System.out.println("not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTask(String name, String task, String date, String start, String end) {
		
		try {
			
			PreparedStatement ps=c.prepareStatement(" update task_details set start=?, end=? where `name`=? and `task`=? and `date`=?;");
			ps.setString(1, start);
			ps.setString(2, end);
			ps.setString(3, name);
			ps.setString(4, task);
			ps.setString(5, date);
			
			ps.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addTask(TaskDetails t) {
		try {
			PreparedStatement ps=c.prepareStatement("insert into task_details(id,name,task,`date`,start,`end`) values (?,?,?,?,?,?)");
			ps.setString(1, "001");
			ps.setString(2, t.getName());
			ps.setString(3, t.getTask());
			ps.setString(4, t.getDate());
			ps.setString(5, t.getStart_time());
			ps.setString(6, t.getEnd_time());
			int k=ps.executeUpdate();
			
			if(k!=1) {
				System.out.println("task added");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public TaskDetails fitIntoTaskDetails(ResultSet rs) throws SQLException {
		TaskDetails t=new TaskDetails();
		t.setId(rs.getString(1));
		t.setName(rs.getString(2));
		t.setTask(rs.getString(3));
		t.setDate(rs.getString(4));
		t.setStart_time(rs.getString(5));
		t.setEnd_time(rs.getString(6));
		t.setDuration(rs.getString(7));
		return t;
	}
}
