<%@ include file="headerUser.jsp" %>

<h1>Edit Room Form</h1>
<form action="editRoom" method="post">
<table>
<tr>
<td>Description:</td>
<td>
<input type="hidden" name="id" value="${roomId}">
<input type="text" name="desc" value="${roomDesc}"></td>
</tr>
<td>Status:</td>
<td><input type="text" name="status" value="${roomStatus}"></td>
</tr>
<tr>
<td>Price:</td>
<td><input type="number" name="price" value="${roomPrice}"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="EditRoomBtn" value="Edit Room"></td>
</tr>
</table>
</form>
</body>
</html>