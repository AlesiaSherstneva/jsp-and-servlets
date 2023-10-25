<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Confirmation Title</title>
</head>
<body>
The student is confirmed: ${param.firstName} ${param.lastName}
<br/><br/>
The student's country: ${param.country}
<br/><br/>
The student's favorite programming language: ${param.favoriteLanguage}
<br/><br/>
Favorite programming languages:
<ul>
    <%
        String[] langs = request.getParameterValues("favoriteLanguages");
        if (langs != null) {
            for (String tempLang : langs) {
                out.println("<li>" + tempLang + "</li>");
            }
        }
    %>
</ul>
</body>
</html>
