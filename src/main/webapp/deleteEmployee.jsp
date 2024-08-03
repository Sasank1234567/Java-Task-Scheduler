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
<title>Delete Employee</title>
</head>
<body>
<div class="area" >
<div class="context">
<center>
	<form action="deleteEmployee" method="post">
		<table>
			<tr><td>Employee Name : </td><td><input type="text" placeholder="enter name" name="name"></td></tr>
		</table>
		<button type="submit">Delete</button>
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