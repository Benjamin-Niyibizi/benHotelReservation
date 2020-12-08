<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${fname == null && lname == null}">
<c:redirect url="/"/>

</c:if>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  background-color: #ddd;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

.tableClass {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

.tableClass td, .tableClass th {
  border: 1px solid #ddd;
  padding: 8px;
}

.tableClass tr:nth-child(even){background-color: #f2f2f2;}

.tableClass tr:hover {background-color: #ddd;}

.tableClass th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="home">Home</a>
  <a href="user">Add User</a>
  <a href="room">Add Room</a>
  <a href="reception">Reception</a>
  <c:if test ="${role == 'Restaurant' || role == 'RestaurantManager'}">
    <a href="restaurant">Restaurant</a>
  </c:if>
  <a href="report">Report</a>
  <a href="logout">Logout</a>
</div>


