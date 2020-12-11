<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Sell Item</title>
</head>
<body>
<font color="black">

<h2>Restaurant Tariff</h2>
<br />
<font color="black">
<div class="tableList">
<form action="sellItemAction" method="post">
Customer: <input type="text" name="customer">

<table class="tableClass">
<tr>
<th>Item ID</th>
<th>Name</th>
<th>Stock</th>
<th>Sell Price</th>
<th>Select Item</th>
<th>Quantity</th>

</tr>
<c:forEach var="item" items="${allItems}">
<tr>
<td>${item.itemId}</td>
<td>${item.name}</td>
<td>${item.availableQuantity}</td>
<td>${item.sellPrice}</td>
<td><input type="checkbox" name='${item.itemId}'></td>
<td><input type="text" name='qnt_${item.itemId}' value="1"></td>
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