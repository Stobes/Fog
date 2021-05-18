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
                <div class="col-sm-4" style="padding: 2px 6px 4px 6px; color:#555555; background-color: #eeeeee; border: #dddddd 2px solid">
                    <h2 > Carport specifikationer.
                        <br>
                    </h2>
                    <p>
                        Dine ønskede mål er:
                        <br>
                        Højde:  ${requestScope.height} cm
                        <br>
                        Bredde: ${requestScope.width} cm
                        <br>
                        Længde: ${requestScope.length} cm
                         </br>

                    </p>
                </div>



                <div class="col-sm-4">
                    Klik her for at se en <a href="${pageContext.request.contextPath}/fc/showSVG">tegning</a>
                    <c:if test="${sessionScope.role == 'employee' }">
                    <p style="font-size: larger">En medarbejder vil verificere din forespørgsel hurtigst muligt <br/><br/>
                        Når din foresprøgsel er blevet godkendt, vil du få tilsendt et tilbud på mail</p>
                    <p><a href="fc/employeepage">Employee Page</a>
                        </c:if>

                        <c:if test="${sessionScope.role == 'customer' }">
                    <p style="font-size: larger">En medarbejder vil verificere din forespørgsel hurtigst muligt <br/><br/>
                        Når din foresprøgsel er blevet godkendt, vil du få tilsendt et tilbud på mail</p>
                    <p><a href="customerpage">Customer Page</a>
                        </c:if>


                        <c:if test="${requestScope.error != null}">
                            <p style="color: red;">
                                    ${requestScope.error}
                            </p>
                        </c:if>

                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
        <br/>


        </div>

    </jsp:body>
</t:genericpage>