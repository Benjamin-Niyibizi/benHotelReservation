<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Report </title>
</head>
<body>
<font color="black">
<h1>Report</h1>
<form action="reportAction" method="post">
StartDate:<input type="text" name="startDate">
EndDate:<input type="text" name="endDate">
Data:<select name="dataType">
<option value="booking">Booking</option>
<option value="reservation">Reservation</option>
</select>
<input type="submit" name="run" value="Run Report">
</form>
<hr>
<c:if test="${bookings.size()> 0}">
<div class="tableList">

<form action="printBookingReport" method="post">
<input type="submit" name="printbillbtn" value="Print Report">
</form>
<table class="tableClass">
<tr>
<td>Booking No:</td>
<td>Names:</td>
<td>CheckIn Date:</td>
<td>Checkout Date:</td>
<td>Nights:</td>
<td>Paid Amount:</td>

</tr>

<c:forEach var="booking" items="${bookings}">
<tr>
<td>${booking.bookingId}</td>
<td>${booking.names}</td>
<td>${booking.startDate}</td>
<td>${booking.checkOutDate}</td>
<td>${booking.nights}</td>
<td>${booking.amount}</td>
</tr>

</c:forEach>
</table>
</div>
</c:if>

<c:if test="${reservations.size()> 0}">
<div class="tableList">

<form action="printReservationReport" method="post">
<input type="submit" name="printReserveBtn" value="Print Report">
</form>

<table class="tableClass">
<tr>
<td>Reservation ID:</td>
<td>Names:</td>
<td>StartDate:</td>
<td>EndDate:</td>
<td>Room ID:</td>
<td>Email :</td>
<td>Telephone:</td>

</tr>

<c:forEach var="reservation" items="${reservations}">
<tr>
<td>${reservation.id}</td>
<td>${reservation.names}</td>
<td>${reservation.startDate}</td>
<td>${reservation.endDate}</td>
<td>${reservation.roomId}</td>
<td>${reservation.email}</td>
<td>${reservation.tel}</td>
</tr>

</c:forEach>
</table>
</div>
</c:if>
</form>

</font>
</body>
</html>