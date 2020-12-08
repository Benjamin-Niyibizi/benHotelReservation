<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Reception</title>
</head>
<body>
<font color="black">

<h2>Restaurant Tarrif</h2>
<br />
<font color="black">
<div class="tableList">
<form action="sellItemAction" method="post">

<table class="tableClass">
<tr>
<th>Item ID</th>
<th>Name</th>
<th>Sell Price</th>
<th>Select Item</th>
<th>Quantity</th>

</tr>
<c:forEach var="item" items="${allItems}">
<tr>
<td>${item.itemId}</td>
<td>${item.name}</td>
<td>${item.sellPrice}</td>
<td><input type="checkbox" name='${item.itemId}'></td>
<td><input type="text" name='qnt_${item.itemId}' size="3"></td>
</td>
</tr>
</c:forEach>
</table>
<input type="submit" name="selltembtn" value="Sell Items">
</form>

</div>

</font>
</body>
</html>