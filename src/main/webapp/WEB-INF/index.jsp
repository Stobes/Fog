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
            <div style="margin-top: 3em;margin-bottom: 3em; text-align: center">
                <h1> Velkommen til Fog Quickbyg </h1>
                <h2> Vi gør dine carport drømme til virkelighed </h2>
                <p> Log venligst ind eller opret en bruger for at kunne bestille tilbud</p>

            </div>
    </jsp:body>
</t:genericpage>