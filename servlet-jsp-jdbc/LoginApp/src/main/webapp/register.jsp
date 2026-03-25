<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
<script src="<%= request.getContextPath() %>/js/script.js"></script>

<div class="container">
    <h2>Register</h2>

    <form action="register" method="post" onsubmit="return validateRegister()">
        <input type="text" id="name" name="name" placeholder="Name">
        <input type="email" id="email" name="email" placeholder="Email">
        <input type="password" id="password" name="password" placeholder="Password">

        <button type="submit">Register</button>
    </form>

    <a href="login.jsp">Login here</a>
</div>