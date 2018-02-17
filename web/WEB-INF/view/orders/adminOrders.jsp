<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<TABLE>
    <tr>
        <th>№</th>
        <th>Order Id</th>
        <%--<th>User id</th>--%>
    </tr>

    <c:forEach var="order" items="${orders}" varStatus="status">
        <tr>
                <%--<td>${status.index + 1}</td>--%>
            <td>${order.id}</td>
            <td>${order.userId}</td>
                <%--<td>${order.durabilityTime}
                   &lt;%&ndash; <form><input></form>&ndash;%&gt;
                </td>--%>
            <td>
                <%--<form action="frontController?command=createOrder" method="post">  --%>
                        <%--<input type="submit" class="btn-success" name="submit" value="Арендовать"/>--%>
            <td class="col-md-1"><input id="${order.id}" class="btn-primary addProductBtn" type="datetime-local"/></td>
            <td class="col-md-1"><input id="${order.id}" class="btn-primary addProductBtn" type="datetime-local"/></td>
            <input type="hidden" value="true" name="paid"/>
            <input type="hidden" name="order" value="${order}">
            <td><input type="submit" class="btn-success" name="paid" value="Оплатить"/></td>
                    <input type="delete" class="btn-error" name="submit" value="reject">
                    <input type="submit" class="btn-success" name="submit" value="accept">
            <%--</form>--%>
            <td>${order.total}</td>
        </tr>
    </c:forEach>
</TABLE>



