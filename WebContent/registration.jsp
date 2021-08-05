<html>
<body>
	<h3>Registration-Form</h3>
	<hr>
		<form action="RegistrationServlet" method="get">
		<table border="1">
			<tr>
			<td>Userid</td><td><input type="text" name="userid"/></td>
			</tr>
			<tr>
			<td>Password</td><td><input type="password" name="password"/></td>
			</tr>
			<tr>
			<td>Gender</td><td>male <input type="radio" name="gender" value="male" checked=checked/> female <input type="radio" name="gender" value="female"/></td>
			</tr>
			<tr>
			<td>Hobbies</td><td>dance <input type="checkbox" name="hobby" value="dance"/> music <input type="checkbox" name="hobby" value="music"/> Sports <input type="checkbox" name="hobby" value="sports"/></td>
			</tr>
			<tr>
			<td>City</td><td><select name="city"><option>delhi</option><option>indore</option><option>mumbai</option></select></td>
			</tr>
			<tr>
			<td>Photo</td><td></td>
			</tr>
			<tr>
			<td><input type="submit" value="Submit"/></td>
			<td><input type="reset" value="Reset"/></td>
			</tr> 
		</table>
		</form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>