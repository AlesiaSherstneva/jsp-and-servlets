<%@ page import="com.luv2code.jsp.*" %>
<html>
<body>
<jsp:include page="header.html"/>
<h3>Hello World of Java!</h3>
<h3>JSP Expressions</h3>
Converting a string to uppercase: <%= "Hello World".toUpperCase() %>
<br><br>
25 multiplied by 4 equals <%= 25 * 4 %>
<br><br>
Is 75 less than 69? <%= 75 < 69 %>
<br><br>
<h3>JSP Scriptlet</h3>
<%
    for (int i = 0; i < 5; i++) {
        out.println("</br>I really luv2code: " + i);
    }
%>
<br><br>
<h3>JSP Declaration</h3>
<%!
    String makeItLower(String data) {
        return data.toLowerCase();
    }
%>
Lower case "Hello World": <%= makeItLower("Hello World") %>
<br><br>
<h3>Java class</h3>
Let's have some fun: <%= makeItLower("FUN FUN FUN")%>
<br><br>
<h3>Built-In Objects</h3>
Request user agent: <%= request.getHeader("User-Agent") %>
<br><br>
Request language: <%= request.getLocale() %>
<jsp:include page="footer.jsp"/>
</body>
</html>