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
<h3>Foreach table with list of Java objects</h3>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gold Customer</th>
    </tr>
    <c:forEach var="tempStudent" items="${students}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
<%--            <td>
                <c:if test="${tempStudent.goldCustomer}">
                    Special Discount
                </c:if>
                <c:if test="${not tempStudent.goldCustomer}">
                    -
                </c:if>
            </td>--%>
            <td>
                <c:choose>
                    <c:when test="${tempStudent.goldCustomer}">
                        Special Discount
                    </c:when>
                    <c:otherwise>
                        -
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>