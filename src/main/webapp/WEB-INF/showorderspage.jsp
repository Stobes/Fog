<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         List of Order Entries.
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        This is a list of all Order requests:

        <table>
            <thead><th>Id</th><th>Højde</th><th>Længde</th><th>Bredte</th></thead>
            <tr><td></td><td></td><td></td><td></td></tr>

        </table>

    </jsp:body>
</t:genericpage>
