<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.roomList{
    background-color: #eee;
    overflow:scroll;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="home">Home</a>
  <div align="right">
    <form action="login" method="post" align="right">
        <font color="white">UserName</font> <input type="text" name="username" size=8 required>
        <font color="white">Password</font> <input type="password" name="pass" size=8 required>
        <input type="submit" name="loginBtn" value="login">
    </form>
  </div>
</div>

<div align="right">
<c:if test="${fname != null && lname != null }">
You are logged as: <b>(${fname} ${lname})
</c:if>
</div>

<h2>HOTEL MANAGEMENT SYSTEM</h2>


