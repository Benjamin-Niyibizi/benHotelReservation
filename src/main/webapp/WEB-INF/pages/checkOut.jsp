<%@ include file="headerUser.jsp" %>
<title>Reception</title>
</head>
<body>
<h3> <font color="black"><a href="checkIn">Check-In</a>|<a href="checkOut">Check-Out</a></font></h3>
<h5>Bill</h5>
<table>
<tr>
    <tr><td>Bill No:</td><td>${booking.bookingId}</td></tr>
    <tr><td>Room Id:</td><td>${booking.roomId}</td></tr>
    <tr><td>Customer Name:</td><td>${booking.names}</td></tr>
    <tr><td>Start Date:</td><td>${booking.startDate}</td></tr>
    <tr><td>End Date:</td><td>${booking.checkOutDate}</td></tr>
    <tr><td>Nights:</td><td>${booking.nights}</td></tr>
    <tr><td>Paid Amount</td><td>${booking.amount}</td></tr>
    <td></td><td></td></tr>
    <td colspan="2">Thank you!</td></tr>
    </tr>
</table>

<form action="printBookingBill" method="post">
<input type="hidden" name="bookingId" value="${booking.bookingId}">
<input type="submit" name="printBillBtn" value="Print Bill">
</form>

</body>
</html>