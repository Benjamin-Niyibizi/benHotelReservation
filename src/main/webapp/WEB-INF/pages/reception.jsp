<%@ include file="headerUser.jsp" %>
<title>Reception</title>
</head>
<body>
<h3> <font color="black"><a href="checkIn">Check-In</a>|<a href="checkOut">Check-Out</a></font></h3>

<h2>Check-In-Form</h2>

<form action="checkInAction" method="POST">
    <table>
        <tr>
            <td>Names:</td>
            <td>
                <select name="names">
                    <c:forEach items="${pendingReservations}" var="reservation">
                    <option value="${reservation.names}">${reservation.names}</option>
                    </c:forEach>
                </select>
               <input type="text"name="otherNames">
            </td>
        </tr>
        <tr>
            <td>Tel:</td><td><input type="text" name="tel"></td>
        </tr>
        <tr>
            <td>Room ID:</td>
            <td>
                <select name="roomId">
                    <c:forEach items="${availableRooms}" var="room">
                    <option value="${room.roomId}">${room.status}(${room.roomId})</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Start Date: </td><td><input type="text" name="startDate"></td>
        </tr>
        <tr>
            <td>End Date: </td><td><input type="text" name="endDate"></td>
        </tr>
        <tr>
            <td></td><td></td>
        </tr>
        <tr>
            <td colspan=2><input type="submit" name="Checkin" value="Check-in"></td>
        </tr>
    </table>
</form>

<h2>CheckStatus</h2>
<form action="checkStatus" method="POST">
Date From:<input type="text" name="dateFrom"/>
        <input type="submit" name="checkBtn" value="Check">
        </form>


<h3>Room Reservations Information</h3>
<div class="roomList">
<font color="black">
<table class="tableClass">
<tr>
    <th>Room Id</th>
    <th>Description</th>
    <th>Price</th>
    <th>Reservation</th>
    <th>More Info</th>

</tr>
<c:forEach items="${roomReservations}" var="room">
    <tr>
        <td>${room.key.roomId}</td>
        <td>${room.key.description}</td>
        <td>${room.key.price}</td>
        <td>
        <table>
        <c:forEach var="reservation" items="${room.value}">
        <tr>
        <td>${reservation.names}</td><td>${reservation.startDate} -${reservation.endDate}</td>
        <td><a href="checkIn?roomId=${reservation.roomId}&names=${reservation.names}&tel=${reservation.tel}&startDate=${reservation.startDate}&endDate=${reservation.endDate}">CheckIn</a></td>
        </tr>
        </c:forEach>
        </table>
        </td>
        <td><a href="roomInfo?roomId=${room.key.roomId}">More Info</a></td>
    </tr>
</c:forEach>
</table>

<h2>Room Bookings Information</h2>
<div class="roomList">
<font color="black">
<table class="tableClass">
<tr>
<th>ID</th>
<th>Description</th>
<th>Prices</th>
<th>Booking</th>
<th>More Info</th>
</tr>
<c:forEach var="room" items="${roomBookings}">
<tr>
<td>${room.key.roomId}</td>
<td>${room.key.description}</td>
<td>${room.key.price}</td>

<td>
<table>
<c:forEach var="booking" items="${room.value}">
<tr>
<td>${booking.names}</td>
<td>${booking.startDate} - ${booking.endDate}</td>
<td><a href="checkOut?bookingId=${booking.bookingId}">CheckOut</a></td>
</tr>
</c:forEach>
</table>
</td>
<td><a href="roomInfo?roomId=${room.key.roomId}">More Info</a></td>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>