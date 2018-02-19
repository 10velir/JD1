<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<body>
<%--<p class="bg-danger"><fmt:message key=" ${errorMsg}"/></p>--%>
<div class="container text-center col-sm-4">
    <form class="form-group" action="frontController?command=login" method="post">
        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="messages" var="i18n"/>
        <form action="frontController?command=signup" method="post">
            <label for="<fmt:message bundle="${i18n}" key="login.login"/>"> <fmt:message bundle="${i18n}" key="login.login"/> </label>
            </br>
            <input type="text" name="login">
            </br>
            <label for="<fmt:message bundle="${i18n}" key="login.login"/>"> <fmt:message bundle="${i18n}" key="login.password"/> </label>
            </br>
            <input type="password" name="password">
            </br>
            <div>name</div>
            <input type="text" name="name">
            </br>
            <input class="btn btn-success" type="submit" name="submit" value="sing up">
        </form>
    </form>
</div>

</body>
