<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<body>
<c:set var="data" value="luv2code"/>
Length of the string: <b>${data}</b>: ${fn:length(data)}
<br/><br/>
Uppercase version of the string: <b>${data}</b>: ${fn:toUpperCase(data)}
<br/><br/>
Does the string <b>${data}</b> starts with <b>luv</b>?: ${fn:startsWith(data, "luv")}
<br/><br/>
<h3>Split Demo</h3>
<c:set var="cities" value="Singapore,Tokyo,Mumbai,London"/>
<c:set var="citiesArray" value="${fn:split(cities, ',')}"/>
<c:forEach var="tempCity" items="${citiesArray}">
    ${tempCity}<br/>
</c:forEach>
<h3>Join Demo</h3>
<c:set var="fun" value="${fn:join(citiesArray, '*')}"/>
Result of joining: ${fun}
</body>
</html>