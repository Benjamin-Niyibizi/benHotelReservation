<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Reception</title>
</head>
<font color="black">
<body>

<h2>Check-In Form</h2>

<form action="checkinAction" method="POST">
<table>
<tr>
<td>Names:</td>
<td><input type="text" name="names" value="${names}">
</td>
</tr>

<tr>
<td>Tel:</td><td>
<input type="text" name="tel" value="${tel}"></td>
</tr>

<tr>
<td>Room ID</td><td>
<input type="text" name="roomId"value="${roomId}"/>
</td>
</tr>

<tr>
<td>Start Date:</td><td>
<input type="text" name="startDate" value="${startDate}"></td>
</tr>

<tr>
<td>End Date:</td><td>
<input type="text" name="endDate"value="${endDate}"></td>
</tr>

<tr>
<td colspan=2><input type="submit" name="Checkin" value="Check-in"></td>
</tr>
</table>
</form>