<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css\index.css">
<style >
	strong{
		color:orange;
		font-size:100px;
	}
</style>
<meta charset="UTF-8">
<title>Task Scheduler</title>
</head>
<body>
<script>
	function go(url){
		document.getElementsByTagName("form")[0].action=url;
		document.getElementsByTagName("form")[0].submit();
	}
	</script>
   

<div class="area" >

			<div class="context">
        <form method="post">
        <center>
        <h1><strong>T</strong>ask</strong>
        <strong>S</strong>cheduler</h1>
		<table>
			<tr>
				<td><button onclick="go('adminLogin.jsp')">Admin</button></td>
				<td><button onclick="go('mangLogin.jsp')">Manager</button></td>
				<td><button onclick="go('empLogin.jsp')">Employee</button></td>
			</tr>
		</table>
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