
<div id="footer">
     
    <footer> &COPY;Researchers Exchange Participations
        <p>${address}</p>
        <p>${port}</p>
         <c:forEach items='${cookie}' var='mapEntry'>
                <c:out value='${mapEntry.key}'/>
                :
                <c:out value='${mapEntry.value.value}'/>
                <br>
            </c:forEach>
            </footer>
</div>
