<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>
TEST


</h2>
<div class="row marketing">
    <div class="col-lg-6">
        <h4>Here's your list of Favorite Movies</h4>

        <p/>

        <table class="table">
            <thead>
            <tr>
                <th>UserName</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${users}" var="allUsers">
                <tr>
                    <td><c:out value="${allUsers.userName}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>
