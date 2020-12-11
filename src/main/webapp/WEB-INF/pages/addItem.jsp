<!DOCTYPE html>
<%@ include file="headerUser.jsp" %>
<title>Add Item</title>
</head>
<body>
<h1><font color="black">Add Item</font></h1>
<form action="addItemAction" method="post">
<table>
<tr>
<td><font color="black">Name:</font></td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td><font color="black">Buy Price:</font></td>
<td><input type="number" name="buyprice"></td>
</tr>
<tr>
<td><font color="black">Sell Price:</font></td>
<td><input type="number" name="sellprice"></td>
</tr>
<tr>
<td><font color="black">Available Quantity:</font></td>
<td><input type="number" name="availableQuantity" value="0"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="AddItembtn" value="Add Item"></td>
</tr>
</table>
</form>
<hr />
<font color="black">

<h2>Restaurant Items</h2>

<div class="tableList">

<table class="tableClass">
<tr>
<th>Item ID</th>
<th>Name</th>
<th>Buy Price</th>
<th>Sell Price</th>
<th>Edit/Delete</th>
</tr>

<c:forEach var="item" items="${allItems}">
<tr>
<td>${item.itemId}</td>
<td>${item.name}</td>
<td>${item.buyPrice}</td>
<td>${item.sellPrice}</td>
<td><a href ="showeditItme?itemId=${item.itemId}&name=${item.name}&buyPrice=${item.buyPrice}&sellPrice=${item.sellPrice}">Edit</a>/<a href="removeItem?itemId=${item.itemId}">Remove</a></td></td>
</td>
</tr>
</c:forEach>
</table>
</table>
</div>
</font>
</body>
</html>