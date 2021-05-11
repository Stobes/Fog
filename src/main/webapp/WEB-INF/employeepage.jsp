<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         FOG Carport Admin page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        <P>You are now logged in as a EMPLOYEE of our FOG Carport site.</P>

        <p><a href="${pageContext.request.contextPath}/fc/orderentries">Gå til visning af alle Order forespørgelser</a></p>
    </jsp:body>
</t:genericpage>
