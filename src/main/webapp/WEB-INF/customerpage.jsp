<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <div>
            <div style="margin-top: 3em;margin-bottom: 3em; text-align: center">
                <h1> Velkommen til Fog Quickbyg </h1>
                <h2> Vi gør dine carport drømme til virkelighed </h2>
            </div>

        </div>
        <div class="row">
            <div class="col-sm-4" style="padding: 2px 6px 4px 6px; color:#555555; background-color: #eeeeee; border: #dddddd 2px solid">
                <h2>Hello ${sessionScope.email}
                    <br>
                </h2>
                <p>
                    You are now logged in as a Customer of our wonderful site.
                    Role: ${sessionScope.role}
                </p>
            </div>

            <div class="col-sm-4">
                <form method="post" action="${pageContext.request.contextPath}/fc/OrderCommand">
                    <div class="form-group">
                        <h3> Bestil Carport </h3>
                        <label for="length">Længde i cm: </label>
                        <input id="length" name="length" type="text" class="form-control mb-3" placeholder="Indtast ønskede længde"/>
                    </div>
                    <div class="form-group">
                        <label for="width">Bredde i cm: </label>
                        <input id="width" name="width" type="text" class="form-control mb-3" placeholder="Indtast ønskede bredde"/>
                    </div>
                    <div class="form-group">
                        <label for="height">Højde i cm: </label>
                        <input id="height" name="height" type="text" class="form-control mb-3" placeholder="Indtast ønskede højde"/>
                    </div>
                    <div>
                        <input type="checkbox" id="shed" name="shed" value="shed">Vælg skur</input>

                        <c:if test="${requestScope.error != null}">
                        <p style="color: red;">
                                ${requestScope.error}
                        </p>
                        </c:if>
                        <br>
                        <button type="submit" class="btn-primary px-2"> Bestil tilbud </button>
                    </div>
                </form>
                <br>
            </div>
        </div>

        </div>
    </jsp:body>

</t:genericpage>

