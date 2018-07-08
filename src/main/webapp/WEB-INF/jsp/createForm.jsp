<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>
<jsp:include page="bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <section>
            <h3>ADD ENTITY</h3>
            <hr>
            <form method="post" action="create">
                <dl>
                    <dt>Name:</dt>
                    <dd><input type="text" size=40 name="name" required></dd>
                </dl>
                <button type="submit">add</button>
            </form>
        </section>
    </div>
</div>
</body>
</html>
