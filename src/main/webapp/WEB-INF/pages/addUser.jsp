<%@ include file="headerUser.jsp" %>

<h1>Add User Form</h1>
<form action="addUser" method="post">
<table>
<tr>
<td>First Name:</td>
<td><input type="text" name="fName"></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" name="lName"></td>
</tr>
<tr>
<td>Username:</td>
<td><input type="text" name="userName"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="pass"></td>
</tr>
<tr>
<td>Role:</td>
<td><input type="text" name="role"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="Adduserbtn" value="Add User"></td>
</tr>
</table>
</form>
</body>
</html>