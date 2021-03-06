<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <meta name="theme-color" content="#7952b3">
</head>

<body>

<header class="d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 border-bottom shadow-sm" style="background-color: midnightblue">
    <div class="h5 my-0 me-md-auto fw-normal">
        <p style="font-size: larger">
            <h2 class="text-white">FOG©</h2>
        </p>
    </div>
    <nav class="my-2 my-md-0 me-md-3 text-white">
        <c:if test="${addHomeLink == null }">
            <a class="p-2 text-white" href="<%=request.getContextPath()%>">Hjem</a>
        </c:if>
        <c:if test="${sessionScope.role == 'employee' }">
            <a class="p-2 text-white" href="${pageContext.request.contextPath}/fc/orderentries">Ordre</a>
        </c:if>
        <c:if test="${sessionScope.role == 'customer' }">
            <a class="p-2 text-white" href="${pageContext.request.contextPath}/fc/customerpage">Profil</a>
        </c:if>
        <c:if test="${sessionScope.role == 'customer' }">
            <a class="p-2 text-white" href="${pageContext.request.contextPath}/fc/showCustomersorders">Ordre</a>
        </c:if>
        <c:if test="${sessionScope.role == 'employee' }">
            <a class="p-2 text-white" href="${pageContext.request.contextPath}/fc/employeepage">Profil</a>
        </c:if>
        <a class="p-2 text-white" href="${pageContext.request.contextPath}/fc/aboutPage">Om os</a>
        <c:if test="${sessionScope.user != null }">
            <a class="p-2 text-white">${sessionScope.user.email}</a>
        </c:if>
    </nav>

    <div class="text-white" style="padding-right: 15px">

        <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
        <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
        <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

        <c:if test="${isNotLoginPage && isNotRegisterPage}">
            <c:if test="${sessionScope.user != null }">
                <a type="button" class="btn btn-sm" style="color: black; background-color: white"
                href="${pageContext.request.contextPath}/fc/logoutcommand">Log ud</a>
            </c:if>
            <c:if test="${sessionScope.user == null }">
                <a type="button" class="btn btn-sm" style="color: black; background-color: white"
                   href="${pageContext.request.contextPath}/fc/loginpage">Log ind</a>
                <a type="button" class="btn btn-sm" style="color: black; background-color: white"
                   href="${pageContext.request.contextPath}/fc/registerpage">Opret bruger</a>
            </c:if>
        </c:if>
    </div>
</header>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>

</body>
</html>