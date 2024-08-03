<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css\index.css">

    <meta charset="UTF-8">
    <style>
    	strong{
			color:orange;
		}
        button{
        height:75px;
        }
        button:hover{
        height:80px;
        }
    </style>
    <script>
        function go(url) {
            if (url) {
                document.getElementById("f").action = url;
                document.getElementById("f").submit();
            }
        }
    </script>
   <title>Admin Home</title>
</head>
<body>
<div class="area" >
<div class="context">
    <center>
        <h1><strong>Welcome</strong> Back Admin</h1>
        <table>
            <form id="f" method="post" onsubmit="return false;">
                <tr>
                    <td><button type="button" onclick="go('addManager.jsp')">Add Manager</button></td>
                    <td><button type="button" onclick="go('addEmployee.jsp')">Add Employee</button></td>
                </tr>
                <tr>
                    <td><button type="button" onclick="go('deleteManager.jsp')">Delete Manager</button></td>
                    <td><button type="button" onclick="go('deleteEmployee.jsp')">Delete Employee</button></td>
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
