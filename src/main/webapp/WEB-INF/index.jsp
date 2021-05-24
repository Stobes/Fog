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
                <img src="https://mediacache.davidsen.as/v-637361749307347739/af/f4/a3d3-fb5a-49b9-aac2-78b0d5882f7b/41619003511_1_0653daa7-df39-4656-8afe-b829b6ac936a.jpg" alt="Carportbillede" width="523" height="523"/>

            </div>
    </jsp:body>
</t:genericpage>