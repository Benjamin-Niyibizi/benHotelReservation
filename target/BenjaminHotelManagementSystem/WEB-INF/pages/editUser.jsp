<%@ include file="headerUser.jsp" %>

<h1>Edit User Form</h1>
<form action="editUser" method="post">
<table>
<tr>
<td>First Name:</td>
<input type="hidden" name="id" value="${userId}">
<td><input type="text" name="fName" value="${firstname}"></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" name="lName" value="${lastname}"></td>
</tr>
<tr>
<td>Role:</td>
<td><input type="text" name="role" value="${role}"></td>
</tr>
<tr>
<td>Username:</td>
<td><input type="text" name="userName" value="${userName}"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="pass" value="${password}"></td>
</tr>
<td colspan="2"><input type="submit" name="EditUserBtn" value="Edit User"></td>
</tr>
</table>
</form>
</body>
</html>