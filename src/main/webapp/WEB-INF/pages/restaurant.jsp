<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Reception</title>
</head>
<body>
<font color="black">
<h1>

<c:if test ="${role == 'RestaurantManager'}">
<a href="addItem">Add Item<a>|
</c:if>

<a href="sellItem">Sell Item<a>|<a href="sellItemRoom">Room<a></h1>
<h2>Restaurant Available Items</h2>
<br />
<font color="black">
<div class="tableList">

<table class="tableClass">
<tr>
<th>Item ID</th>
<th>Name</th>
<!-- display buy price header when user is restaurant manager -->
<th>Sell Price</th>
</tr>

<c:forEach var="item" items="${allItems}">
<tr>
<td>${item.itemId}</td>
<td>${item.name}</td>
<!-- display buy price when user is restaurant manager -->
<td>${item.sellPrice}</td>
</td>
</tr>
</c:forEach>

</table>
</div>

</font>
</body>
</html>