<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<body>
<jsp:include page="bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <section>
            <h2 align="center">TABLE</h2>
            <form method="post" action="filter">
                <dl>
                    <dt>Name:</dt>
                    <dd><input type="text" name="name"></dd>
                </dl>
                <button type="submit">search</button>
            </form>
            <form action="table">
                <button type="submit">clear</button>
            </form>
            <hr/>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                </tr>
                </thead>
                <c:forEach items="${table}" var="entity">
                    <jsp:useBean id="entity" scope="page" type="CDEK.model.Entity"/>
                    <tr>
                        <td>${entity.id}</td>
                        <td>${entity.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
        <hr>
        <form action="create">
            <button type="submit">add</button>
        </form>
    </div>
</div>
</body>
</html>