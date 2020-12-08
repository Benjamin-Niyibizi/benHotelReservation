<%@ include file="header.jsp" %>

<h1>Reservation Form</h1>
<form action="reservation" method="post">
<table>
<tr>
<td>Names:</td>
<td>
<input type="hidden" name="id" value="${roomId}">
<input type="text" name="names"></td>
</tr>
<td>Tel:</td>
<td><input type="text" name="telephone"></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email"></td>
</tr>

<td>Start DAte:</td>
<td><input type="date" name="startDate"></td>
</tr>
<tr>
<tr>
<td>End Date:</td>
<td><input type="date" name="endDate"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="reserveRoomBtn" value="Reservation"></td>
</tr>
</table>
</form>
</body>
</html>