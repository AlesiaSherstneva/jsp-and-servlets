<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" %>
<html>
<body>
<form action="todo-demo.jsp">
    Add new item: <input type="text" name="theItem"/>
    <input type="submit" value="Submit"/>
</form>
<%
    List<String> items = (List<String>) session.getAttribute("toDoList");
    if (items == null) {
        items = new ArrayList<>();
        session.setAttribute("toDoList", items);
    }
    String theItem = request.getParameter("theItem");
    if (theItem != null && !theItem.trim().equals("")) {
        items.add(theItem);
    }
%>
<hr>
<b>ToDo List Items</b>
<br/>
<ol>
    <%
        for (String temp : items) {
            out.println("<li>" + temp + "</li>");
        }
    %>
</ol>
</body>
</html>