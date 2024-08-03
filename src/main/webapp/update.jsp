<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css\index.css">

<style>
	td {
	    padding: 20px;
	    background-color:rgb(0,0,0,0.3);
	    margin:5px;
	}
	
	input {
	    text-align: center;
	    width: 100%;
	    font-size: larger;
	    font-family: sans-serif;
	}
	input:focus{
		outline:none;
	}
	button {
	    height: 50px;
	    margin: 10px;
	    width: 150px;
	    background-color: mediumturquoise;
	    border-radius: 8px;
	    color: white;
	    font-size: larger;
	    font-family: sans-serif;
	    border: none;
	}
</style>

<meta charset="UTF-8">
<title>Update Task</title>
</head>
<body>
<script>
	
	function pop(){
		console.log("popup")
		window.alert("Name , Task , Date are fixed by your superiors.");
	}
</script>
<div class="area" >
<div class="context">
				<center>
					<form action="editTask" method="post">
						<table>
							<tr><td>Name : </td><td><input type="text" onclick="pop()" name="name" value=<%=session.getAttribute("emp_name") %> readonly></td></tr>
							<tr><td>Task : </td><td><input type="text" onclick="pop()" name="task" value=<%=request.getParameter("task") %> readonly></td></tr>
							<tr><td>Date : </td><td><input type="date" onclick="pop()"name="date" value=<%=request.getParameter("date") %> readonly></td></tr>
							<tr><td>Start : </td><td><input type="time" name="start"  value="hh-mm-ss"></td></tr>
							<tr><td>End : </td><td><input type="time" name="end" value="hh-mm-ss"></td></tr>
						</table>
						<button type="submit"  >Update</button>
					</form>
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