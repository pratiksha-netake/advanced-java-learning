<%@ page import="Model.Student" %>

<%
Student s = (Student) request.getAttribute("student");
%>

<form action="StudentServlet" method="get">

<input type="hidden" name="action" value="<%= (s==null)?"insert":"update" %>">

<% if(s!=null){ %>
<input type="hidden" name="id" value="<%= s.getId() %>">
<% } %>

Name: <input type="text" name="name" value="<%= (s!=null)?s.getName():"" %>"><br>
Email: <input type="text" name="email" value="<%= (s!=null)?s.getEmail():"" %>"><br>
Course: <input type="text" name="course" value="<%= (s!=null)?s.getCourse():"" %>"><br>

<input type="submit" value="Save">
</form>