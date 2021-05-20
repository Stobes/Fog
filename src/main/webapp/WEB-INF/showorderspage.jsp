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
        <h1>Velkommen ${sessionScope.email} </h1>
        Dette er en liste over alle ordreforespørgsler:

        <table>
            <thead>
            <th>Id</th>
            <th>Højde</th>
            <th>Længde</th>
            <th>Bredde</th>
            <th>Status</th>
            </thead>
            <c:forEach var="orderEntry" items="${requestScope.orderEntryList}">
                <tr>
                    <form method="post" action="${pageContext.request.contextPath}/fc/inspectOrder">
                        <td>${orderEntry.id}</td>
                        <td>${orderEntry.height}</td>
                        <td>${orderEntry.length}</td>
                        <td>${orderEntry.width}</td>
                        <td>${orderEntry.status}</td>
                        <td><button name="Inspect Order" type="submit" value="${orderEntry.id}">Inspicer ordre</button></td>
                    </form>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:genericpage>
