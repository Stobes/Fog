<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <div style="margin-top: 3em;margin-bottom: 3em; text-align: center">
                <h1> Ordreoversigt </h1>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <p style="padding: 2px 6px 4px 6px; color:#555555; background-color: #eeeeee; border: #dddddd 2px solid"> Kundeoplysninger
                        <br>
                        {Skal hente intastede oplysninger og vise dem her.}
                        dine ønskede mål er:
                        højde:  ${requestScope.height} cm
                        bredte: ${requestScope.width} cm
                        længde: ${requestScope.length} cm
                         </br>
                    </p>
                </div>
                <div class="col-sm-4">


                        <c:if test="${requestScope.error != null}">
                            <p style="color: red;">
                                    ${requestScope.error}
                            </p>
                        </c:if>

                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>

        <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an employee</p>
            <p><a href="fc/employeepage">Employee Page</a>
        </c:if>

        <c:if test="${sessionScope.role == 'customer' }">
            <p style="font-size: larger">This is what you can do, since your
                are logged in as a customer</p>
            <p><a href="fc/customerpage">Customer Page</a>
        </c:if>

        </div>

    </jsp:body>
</t:genericpage>