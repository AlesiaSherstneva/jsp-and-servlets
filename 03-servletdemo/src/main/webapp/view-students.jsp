<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:forEach var="tempStudent" items="${student-list}">
    ${tempStudent}<br/>
</c:forEach>
</body>
</html>