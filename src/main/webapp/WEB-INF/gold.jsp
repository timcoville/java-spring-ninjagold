<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Ninja Gold</title>
</head>
<body>
<div id="wrapper">
<h1>Ninja Gold Hunter</h1>
        <div class="header">
            Your Gold:
            <div class="gold"><c:out value="${gold}"/></div>
        </div>
        <div class="option">
            <h1>Farm</h1>
            <h2>(earns 10-20 gold)</h2>
            <form action="/process" method="post">
                <input type="hidden" name="building" value="farm">
                <input type="submit" value="Find Gold!">
            </form>
        </div> 
        <div class="option">
                <h1>Cave</h1>
                <h2>(earns 5-10 gold)</h2>
                <form action="/process" method="post">
                    <input type="hidden" name="building" value="cave">
                    <input type="submit" value="Find Gold!">
                </form>
        </div> 
        <div class="option">
                <h1>House</h1>
                <h2>(earns 2-5 gold)</h2>
                <form action="/process" method="post">
                    <input type="hidden" name="building" value="house">
                    <input type="submit" value="Find Gold!">
                </form>
        </div> 
        <div class="option">
                <h1>Casino</h1>
                <h2>(earns/lose 0-50 gold)</h2>
                <form action="/process" method="post">
                    <input type="hidden" name="building" value="casino">
                    <input type="submit" value="Find Gold!">
                </form>
        </div>
        Activities:
        <div id="activities">
            <c:forEach var="activity" items="${activities}" >
            <p><c:out value="${activity}"/></p>
            </c:forEach>
        </div>
    </div>

</body>
</html>