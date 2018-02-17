<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-hover">
    <tr>
        <th class="col-md-2">№</th>
        <th class="col-md-2">Order id</th>
        <th class="col-md-2">User id</th>
        <th class="col-md-2">Sum</th>
    </tr>

    <c:forEach var="order" items="${orders}" varStatus="status">
        <tr class="info">
            <td class="col-md-2">${status.index + 1}</td>
            <td class="col-md-2">${order.id}</td>
            <td class="col-md-2">${order.userId}</td>
            <td class="col-md-2">${order.total}</td>
        </tr>
    </c:forEach>
</table>
