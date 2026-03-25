<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<script src="<%= request.getContextPath() %>/js/script.js"></script>

<div class="container">
    <h2>Login</h2>

    <form action="login" method="post" onsubmit="return validateLogin()">
        <input type="text" id="email" name="email" placeholder="Email">
        <input type="password" id="password" name="password" placeholder="Password">

        <button type="submit">Login</button>
    </form>

    <a href="register.jsp">Register here</a>

    <%
    if(request.getParameter("error") != null){
    %>
        <div class="error">Invalid Login</div>
    <%
    }
    %>
</div>