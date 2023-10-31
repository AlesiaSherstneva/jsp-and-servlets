<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Training Portal</title>
</head>
<body>
<%
    String favLang = "Java";
    Cookie[] theCookies = request.getCookies();
    if (theCookies != null) {
        for (Cookie tempCookie : theCookies) {
            if ("myApp.favLang".equals(tempCookie.getName())) {
                favLang = tempCookie.getValue();
                break;
            }
        }
    }
%>
<h4>New Books for <%= favLang %>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>
<h4>Latest News Reports for <%= favLang %>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>
<h4>Hot Jobs for <%= favLang %>
</h4>
<ul>
    <li>blah blah blah</li>
    <li>blah blah blah</li>
</ul>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>
