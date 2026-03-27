<%@ page import="java.util.*, Model.Student" %>

<h2>Student List</h2>
<a href="StudentServlet?action=new">Add Student</a>

<table border="1">
<tr>
    <th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Action</th>
</tr>

<%
List<Student> list = (List<Student>) request.getAttribute("list");
for(Student s : list) {
%>
<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getCourse() %></td>
<td>
    <a href="StudentServlet?action=edit&id=<%= s.getId() %>">Edit</a>
    <a href="StudentServlet?action=delete&id=<%= s.getId() %>">Delete</a>
</td>
</tr>
<% } %>
</table>