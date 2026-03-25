<%@ page session="true" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<%
String user = (String) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
}
%>

<div class="container">
    <h2>Welcome <%= user %></h2>

    <a href="<%= request.getContextPath() %>/logout">
        <button>Logout</button>
    </a>
</div>