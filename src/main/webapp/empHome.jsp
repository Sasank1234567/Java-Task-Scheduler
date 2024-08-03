<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, java.util.Iterator, com.entity.TaskDetails" %>
<% 
  List<TaskDetails> l = (ArrayList<TaskDetails>) session.getAttribute("tasks");
  Iterator i = l.iterator();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css\index.css?v=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
	strong{
		color:orange;
	}
	.context{
	top:0vh;
	}
  input {
  	
    margin: none;
    color: inherit;
    background: none;
    border: none;
    font-weight:bold;
    text-align: center;
    font-size: inherit;
    font-family: inherit;
  }
  button{
  	width:65px;
  	height:65px;
  }
  button:hover{
  	width:65px;
  	height:65px;
  	margin:inherit;
  }
  .cell {
    padding: 10px;
    font-size: large;
    border: none;
  }
  
  button {
    color: seagreen;
    font-size: x-large;
    padding: 0px;
    margin: 0px;
    background-color: seashell;
    outline: none;
    border-style: dotted;
    transform: scale(-1, 1);
  }
  	td {
	   background-color:rgb(0,0,0,0.2);
	}
	th {
	   background-color:rgb(0,255,0,0.2);
	   color:white;
	}
</style>
<meta charset="UTF-8">
<title>Employee Home</title>
</head>
<body>
<div class="area" >

		<div class="context">
		<center>
		  <h1><strong>Welcome</strong> <%=session.getAttribute("emp_name") %></h1>
		    
		    
		  <script>
		    function submitForm(formElement, actionUrl) {
		      formElement.action = actionUrl;
		      formElement.submit();
		    }
		  </script>
		  
		  
		  <table>
		    <tr>
		      <th class="cell">Task Name</th>
		      <th class="cell">Date</th>
		      <th class="cell">Start Time</th>
		      <th class="cell">End Time</th>
		      <th class="cell">Duration</th>
		      <th class="cell">Edit</th>
		      <th class="cell">Delete</th>
		    </tr>
		    
		    <% 
		    int c = 0;
		    while (i.hasNext()) { 
		      TaskDetails t = (TaskDetails) i.next();
		    %>
		    <tr>
		      <form id="form_<%= c %>" method="post">
		        <td class="cell"><input type="text" name="task" value="<%= t.getTask() %>" readonly></td>
		        <td class="cell"><input type="text" name="date" value="<%= t.getDate() %>" readonly></td>
		        <td class="cell"><%= t.getStart_time() %></td>      
		        <td class="cell"><%= t.getEnd_time() %></td>
		        <td class="cell"><%= t.getDuration() %></td> 
		        <td class="cell">
		          <button type="button" onClick="submitForm(document.getElementById('form_<%= c %>'), 'update.jsp')">✎</button>
		        </td>
		        <td class="cell">  
		          <button type="button" onClick="submitForm(document.getElementById('form_<%= c %>'), 'deleteTask')" ><i class="material-icons">delete</i></button>
		        </td>
		      </form>
		    </tr>
		    <% 
		      c++;
		    } 
		    %>
		  </table>
		</center>
		</div>
			
	
            <ul class="circles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
</div >
</body>
</html>
