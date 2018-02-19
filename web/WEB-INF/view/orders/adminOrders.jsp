<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    <div class="container-fluid">
        <table class="table table-hover">
            <tr>
                <th class="col-md-4">Order id</th>
                <div class="col-md-8">
                    <th class="col-md-4">User id</th>
                    <%-- <th class="col-md-1">Quantity</th>--%>
                    <th class="col-md-1">Price</th>
                    <th class="col-md-1"></th>
                </div>
            </tr>
            <script>
                function callAlert(productId) {
                    alert(productId);
                }
            </script>

            <c:forEach var="order" items="${allOrders}" varStatus="status">
            <tr class="info">
                <td class="col-md-4">${order.id}</td>
                <td class="col-md-4">${order.userId}</td>
                <td>
                    <c:forEach var="item" items="${order.items}" varStatus="status">
                    <br>
                <td class="col-md-4">id car: ${item.productId}</td>
                <td>
                    <div>
                        <form action="frontController?command=adminOrders" method="post">
                            <input type="text" name="comment">
                            <input class="btn btn-danger col-md-6" type="submit" name="disapprove" value="disapprove"/>
                        </form>
                        <form action="frontController?command=adminOrders" method="post">
                            <input class="btn btn-success col-md-6" type="submit" name="approve" value="approve">
                        </form>
                    </div>
                </td>
                <td>

                </td>
                </c:forEach>
                </td>
                </c:forEach>

            </tr>

        </table>
    </div>

</div>