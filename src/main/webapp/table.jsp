<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Users</h2>
<section>
        <h3><a href="index.html">Home</a></h3>
        <h2>TABLE</h2>
        <hr/>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
        <tr>
                <th>ID</th>
                <th>NAME</th>
            </tr>
        </thead>
            <c:forEach items="${table}" var="entity">
                <jsp:useBean id="entity" scope="page" type="CDEK.model.Entity"/>
                <tr >
                    <td>${entity.iD}</td>
                    <td>${entity.name}</td>
                </tr>
            </c:forEach>
        </table>
    </section>
</body>
</html>