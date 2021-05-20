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

        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Længde</th>
                <th scope="col">Antal</th>
                <th scope="col">Enhed</th>
                <th scope="col">Beskrivelse</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="BOMItem" items="${requestScope.BOMList}">
                <tr>
                    <td>${BOMItem.materialDescription}</td>
                    <td>${BOMItem.length}</td>
                    <td>${BOMItem.amount}</td>
                    <td>${BOMItem.unit}</td>
                    <td>${BOMItem.contextDescription}</td>
                </tr>
            </c:forEach>

            <tr>
                <th colspan="4" scope="row">Total</th>
                <td>
                    ${requestScope.total} kr.
                </td>
            </tr>

            </tbody>

        </table>
        <br/>
        <form method="post" action="${pageContext.request.contextPath}/fc/sendOffer">
            <input type="hidden" name="orderId" value="${requestScope.orderId}">
            <button name="total" type="submit" value="${requestScope.total}">Send tilbud</button>

        </form>

        <br>
        ${requestScope.SVG}

    </jsp:body>
</t:genericpage>
