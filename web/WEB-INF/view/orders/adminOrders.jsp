<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    <div class="container-fluid">
        <table class="table table-hover">
            <tr>
                <th class="col-md-4">Supplier</th>
                <div class="col-md-8">
                    <th class="col-md-4">Model</th>
                    <th class="col-md-1">Quantity</th>
                    <th class="col-md-1">Price</th>
                    <th class="col-md-1"></th>
                </div>
            </tr>
            <script>
                function callAlert(productId) {
                    alert(productId);
                }
            </script>
            <c:forEach var="car" items="${products}" varStatus="status">
                <tr class="info">
                    <td class="col-md-4">${car.supplier}</td>
                    <div class="col-md-8">
                        <td class="col-md-4">${car.model}</td>
                        <td id="count${car.id}" class="col-md-1">0</td>
                        <td class="col-md-1">${car.price}</td>
                        <td>
                            <form action="frontController?command=createOrder" method="post">
                                <input type="hidden" name="productId" value="${car.id}">
                                <input type="submit" class="btn-success" name="submit" value="Арендовать">
                                    <%--<form action="frontController?command=createOrder" method="post">


                                <td class="col-md-1"><input id="${order.id}" class="btn-primary addProductBtn" type="datetime-local"
                                                            title="Добавить в корзину" /></td>
                                <td class="col-md-1"><input id="${order.id}" class="btn-primary addProductBtn" type="datetime-local"
                                                            title="Добавить в корзину" /></td>
                                <td><input type="submit" class="btn-success" name="submit" value="Оплатить"></td>--%>
                            </form>
                        </td>
                            <%--<td class="col-md-1"><input id="${car.id}" class="btn-primary addProductBtn" type="button" title="Добавить в корзину" value="+"/></td>
                        <td class="col-md-1"><input id="${car.id}" class="btn-primary reduceProductBtn" type="button" title="Удалить 1 из корзину" value="-"/></td>--%>
                    </div>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>