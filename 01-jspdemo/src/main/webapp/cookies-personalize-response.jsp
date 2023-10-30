<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<%
    String favLang = request.getParameter("favLang");
    Cookie theCookie = new Cookie("myApp.favLang", favLang);
    theCookie.setMaxAge(60 * 60 * 24 * 365);
    response.addCookie(theCookie);
%>
<body>
Thanks! We set your favorite language to: ${param.favLang}
<br/><br/>
<a href="cookies-homepage.jsp">Return to homepage</a>
</body>
</html>
