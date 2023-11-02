<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String[] cities = {"Mumbai", "Singapore", "Philadelphia"};
    pageContext.setAttribute("theCities", cities);
%>
<html>
<body>
<c:set var="stuff" value="<%= new java.util.Date() %>"/>
Time on the server is ${stuff}
<br/>
<h3>Foreach example with simple scriptlet array</h3>
<c:forEach var="tempCity" items="${theCities}">
    ${tempCity}<br/>
</c:forEach>
</body>
</html>