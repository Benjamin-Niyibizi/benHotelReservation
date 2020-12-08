<%@ include file="headerUser.jsp" %>
<div align="right">
      You are logged as: <b>(${fname} ${lname})
      </div>

<h3>Users List</h3>

<table class="tableClass">
<tr>
    <th>User Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Role</th>
    <th>Username</th>
    <th>Edit/Remove</th>
</tr>
<c:forEach items="${allUsers}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.role}</td>
        <td>${user.userName}</td>
        <td><a href="showEditUser?id=${user.id}&fName=${user.firstName}&lName=${user.lastName}&role=${user.role}&userName=${user.userName}&password=${user.password}">Edit</a>/<a href ="removeUser?id=${user.id}">Remove</a></td>

    </tr>
</c:forEach>
</table>

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
        <td><a href="showEditRoom?id=${room.roomId}&desc=${room.description}&price =${room.price}&status =${room.status}">Edit</a>/<a href ="removeUser?id=${room.roomId}">Remove</a></td>
    </tr>
</c:forEach>
</table>
</div>

</body>
</html>