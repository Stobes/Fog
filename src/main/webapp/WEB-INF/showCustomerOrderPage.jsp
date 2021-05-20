<%--
  Created by IntelliJ IDEA.
  User: 45319
  Date: 18-05-2021
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        <h2>Here is a list of your offers.</h2> <br/>
        <h3>Press accept to confirm purchase of your carport or press Decline to refuse offer.</h3>
    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>
    <jsp:body>
        <div>
            Here is a list of your offers.
            Press accept to confirm purchase of your carport or press Decline to refuse offer.
        </div>
        <table class="table">
            <thead>
            <th scope="col">Id</th>
            <th scope="col">Højde</th>
            <th scope="col">Længde</th>
            <th scope="col">Bredte</th>
            <th scope="col">Status</th>
            <th scope="col">Pris</th>
            </thead>
            <c:forEach var="orderEntry" items="${requestScope.customerOrders}">
                <tr>
                    <form method="post" action="${pageContext.request.contextPath}/fc/offerReply">
                        <th scope="row">${orderEntry.id}</th>
                        <td>${orderEntry.height}</td>
                        <td>${orderEntry.length}</td>
                        <td>${orderEntry.width}</td>
                        <td>${orderEntry.status}</td>
                        <td>${orderEntry.price}</td>
                        <td><button name="reply" type="submit" value="Accept">Accept Offer</button></td>
                        <td><button name="reply" type="submit" value="Decline">Decline Offer</button></td>
                        <input type="hidden" name="orderID" value="${orderEntry.id}">
                    </form>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</t:genericpage>