<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="javascript/adminLogin.js?v=1"></script>
<link rel="stylesheet" href="css\index.css">
<style>
	strong{
		color:orange;
		font-size:100px;
	}
.context{
	top:25vh;
	}

</style>
<meta charset="UTF-8">
<title>Admin LogIn</title>
</head>
<body>
<div class="area" >

			<div class="context">
				<center>

					<h1><strong>A</strong>dmin <strong>L</strong>og-In</h1>
					<form action="" method="post">
						<table>
							
							<tr>
								<td>Username : </td><td><input name="username"/></td>
							</tr>
							<tr>
								<td>Password : </td><td><input type="password" name="password"/></td>
							</tr>
							<tr><td></td><td><button onclick="go()">Log In</button></td></tr>
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