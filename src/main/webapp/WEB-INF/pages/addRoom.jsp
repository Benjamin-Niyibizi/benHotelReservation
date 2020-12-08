<%@ include file="headerUser.jsp" %>

<h1>Add Room Form</h1>
<form action="addRoomAction" method="post">
<table>
<tr>
<td><font color="black">Description:</font></td>
<td><input type="text" name="desc"></td>
</tr>
<td><font color="black">Price:</font></td>
<td><input type="number" name="price"></td>
</tr>
<tr>
<td><font color="black">Status:</font></td>
<td><input type="text" name="status" value="Available" status="true"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="AddRoomBtn" value="Add Room"></td>
</tr>
</table>
</form>
<hr/>
<h3>Rooms and Prices</h3>
<div class="roomList">
<font color="black">
<table class="tableClass">
<tr>
    <th>Room Id</th>
    <th>Description</th>
    <th>Price</th>
    <th>Status</th>
    <th>Edit/Remove</th>

</tr>
<c:forEach items="${allRooms}" var="room">
    <tr>
        <td>${room.roomId}</td>
        <td>${room.description}</td>
        <td>${room.price}</td>
          <td>
                <c:if test="${room.status == 'Available'}">
                    <a href="reservation?id=${room.roomId}">${room.status}</a>
                </c:if>

                <c:if test="${room.status!='Available'}">
                ${room.status}
                </c:if>
                </td>
                <td><a href="showEditRoom?id=${room.roomId}&description=${room.description}&price=${room.price}&status=${room.status}">Edit</a>/<a href ="removeRoom?id=${room.roomId}">Remove</a></td>

    </tr>
</c:forEach>
</table>
</div>
</body>
</html>