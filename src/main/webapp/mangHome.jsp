<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css\index.css">

<style>
	strong{
		color:orange;
	}
	button {
	    height:75px;
	    width:175px;
	}
	button:hover{
		height:80px;
		width:185px;
	}

</style>
<meta charset="UTF-8">
<title>Manager Home</title>
</head>
<body>
<div class="area" >
<div class="context">
<center>
	<h1>
		<strong>Welcome!!</strong> manager <strong><%=(String) session.getAttribute("mang_name") %>...</strong>
	</h1>
	
	<script>
	function go(url){
		document.getElementById("i").action=url;
		document.getElementById("i").submit();
	}
	</script>
	<table>
	<form id="i" method="post">
		<tr>
		<td></td>
		<td><button onclick="go('addTask.jsp')">Add Task</button></td>
		<td></td>
		</tr>
		<tr>
		<td><button  onclick="go('weeklyDetails.jsp')">Weekly performance</button></td>
		<td></td>
		<td><button onclick="go('monthlyDetails.jsp')">Monthly performance</button></td>
		</tr>
		<tr>
		<td></td>
		<td><button onclick="go('index.jsp')">Log out</button></td>
		<td></td>
		
		</tr>
	</form>
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