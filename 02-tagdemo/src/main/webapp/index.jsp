<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, com.luv2code.jsp.Student" %>
<%
    String[] cities = {"Mumbai", "Singapore", "Philadelphia"};
    pageContext.setAttribute("theCities", cities);

    List<Student> data = new ArrayList<>();
    data.add(new Student("John", "Doe", false));
    data.add(new Student("Maxwell", "Johnson", false));
    data.add(new Student("Mary", "Public", true));
    pageContext.setAttribute("students", data);
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
<h3>Foreach example with list of Java objects</h3>
<c:forEach var="tempStudent" items="${students}">
    ${tempStudent.firstName} ${tempStudent.lastName} ${tempStudent.goldCustomer}
    <br/>
</c:forEach>
</body>
</html>