<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${theLocale}"/>
<fmt:setBundle basename="labels"/>
<html>
<body>
<a href="i18n.jsp?theLocale=en_US">English (US)</a>
<a href="i18n.jsp?theLocale=es_ES">Spanish (ES)</a>
<a href="i18n.jsp?theLocale=de_DE">German (DE)</a>
<hr>
<fmt:message key="label.greetings"/><br/><br/>
<fmt:message key="label.firstname"/> <i>John</i><br/>
<fmt:message key="label.lastname"/> <i>Doe</i><br/>
<fmt:message key="label.welcome"/><br/>
<hr>
Selected locale: ${theLocale}
</body>
</html>