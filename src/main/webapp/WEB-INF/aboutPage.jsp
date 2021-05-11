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
            <h1> OM FOG CARPORT </h1>
            <h2> Dette er et eksamens skoleprojekt på 2. semester </h2>
            <p> Vores vision er at vores kunder får deres drømme carport ud for deres helt egne mål. <br>
                Vores eksperter beregner på dine mål og giver dig en færdig pris på dit produkt.<br>
                Så inden længe har du din nye drømme carport.
            </p>


        </div>



        </div>

    </jsp:body>
</t:genericpage>