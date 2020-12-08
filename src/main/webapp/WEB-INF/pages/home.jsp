<%@ include file="header.jsp" %>

<h3>Rooms and Prices</h3>
<div class="roomList">
<font color="black">
<table class="tableClass">
<tr>
    <th>Room Id</th>
    <th>Description</th>
    <th>Price</th>
    <th>Status</th>

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
    </tr>
</c:forEach>
</table>
</div>

</body>
</html>