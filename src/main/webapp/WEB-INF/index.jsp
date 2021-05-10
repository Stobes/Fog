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
                <h1> Velkommen til Fog Quickbyg </h1>
                <h2> Vi gør dine carport drømme til virkelighed </h2>
            </div>
            <div class="row">
                <div class="col-sm-4"></div>
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
                            <input type="checkbox" id="shed" name="shed" value="" onclick="showLabels()">Vælg skur
                                <p id="text" style="display:none">du har vælge skur!</p>
                            </input>
                        </div>
                        <br>
                        <h3> Kontaktinformation </h3>
                        <div class="form-group">
                            <label for="email">Email adresse: </label>
                            <input id="email" name="email" type="text" class="form-control mb-3" placeholder="Indtast din e-mail"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Navn: </label>
                            <input id="name" name="name" type="text" class="form-control mb-3" placeholder="Indtast dit navn"/>
                        </div>
                        <div class="form-group">
                            <label for="adress">Adresse: </label>
                            <input id="adress" name="adress" type="text" class="form-control mb-3" placeholder="Indtast hjemmeadresse"/>
                        </div>
                        <div class="form-group">
                            <label for="zipcode">Postnummer: </label> <br>
                            <input id="zipcode" name="zipcode" type="text" class="form-control" placeholder="Indtast postnummer"/>
                        </div>
                        <c:if test="${requestScope.error != null}">
                        <p style="color: red;">
                                ${requestScope.error}
                        </p>
                        </c:if>
                        <br>
                        <button type="submit" class="btn-primary px-2"> Bestil tilbud </button>
                    </form>
                    <br>
                    <form method="post" action="${pageContext.request.contextPath}/fc/registerpage">
                        <button type="submit" class="btn-primary px-2"> Jeg vil gerne have en ny bruger </button>
                    </form>
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