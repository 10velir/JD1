<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<p class="bg-danger"><fmt:message key=" ${errorMsg}"/></p>--%>
<div class="container text-center col-md-4">
    <form class="form-group" action="frontController?command=login" method="post">
        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="messages" var="i18n"/>
        <label for="<fmt:message bundle="${i18n}" key="login.login"/>"> <fmt:message bundle="${i18n}" key="login.login"/> </label>
        <input class="form-control" type="text" name="login" maxlength="30" placeholder="<fmt:message bundle="${i18n}" key="login.placeholderlog" />">
        <br/>
        <label for="<fmt:message bundle="${i18n}" key="login.login"/>"> <fmt:message bundle="${i18n}" key="login.password"/> </label>
        <input class="form-control" type="password" name="password" maxlength="30" placeholder="<fmt:message bundle="${i18n}" key="login.placeholderpass"/>">
        <br/>
        <input type="submit" class="btn btn-success" value="<fmt:message bundle="${i18n}" key="login.submit"/>">
    </form>
</div>
