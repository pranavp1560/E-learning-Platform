<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <!-- <link rel="stylesheet" href="register.css"> -->
    <style>
    @charset "UTF-8";
body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0f3fc;
}
h2{
    margin-left: 135px;
}

.container {
    background-color: white;
    padding: 30px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 25%;
}

form {
    display: flex;
    flex-direction: column;
}
label {
    margin-bottom: 5px;
    opacity: 0.8;

}
label:hover{
    opacity: 1;
}

input {
    margin-bottom: 10px;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 3px;
}

button {
    padding: 10px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    width: 107%;
}

button:hover {
    background-color: #0056b3;
}
#message {
    margin-top: 10px;
    color:red;
}
.input{
    width: 100%;
}
.input:hover{
    label{
        opacity: 1;
    }
}
.link{
    display:flex
}
    </style>
</head>
<body>
    <div class="container">
        <h2><a href="./register.jsp" >Sign Up</a></h2>
        <form id="registerForm" action="${pageContext.request.contextPath}/RegisteredServlet" method="post">
            <br>
            <label for="username">Username:</label>
            <input type="text" placeholder="Enter Username" id="username" class="input" name="username" required>
            <br>
            <label for="mobile">Mobile No.:</label>
            <input type="t
            ext" placeholder="Enter Mobile Number" id="mobile" class="input" name="mobile" required>
            <br>
            <label for="email">Email:</label>
            <input type="email" id="email" placeholder="Enter Email" class="input" name="email" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" placeholder="Enter Password" class="input" name="password" required>
            <br>
            <label for="Course">Course:</label>
              <select class="input" style="width:100%;" name="course" >
                                        <option selected>Select A courses</option>
                                        <option value="1">CA </option>
                                        <option value="2">CMA</option>
                                        <option value="3">CS </option>
                                         <option value="4">CLAT </option>
                                         <option value="5">HSC</option>
                                    </select>
            <br>
            <button onclick="verifyPassword()" type="submit">Submit</button><br>
            <div class="link">
                If you are already registerd then &ensp;<a href="./signin.jsp" >Sign IN</a> 
            </div>
        </form>
        <p id="message"></p>
            <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>
</html>