<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
   <!--  <link rel="stylesheet" href="register.css"> -->
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
        <h2><a href="./signin.jsp" >Sign IN</a> </h2>
        <form id="registerForm" action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <br>
         
            <label for="mobile">Mobile No.:</label>
            <input type="text" placeholder="Enter Mobile Number" id="mobile" class="input" name="mobile" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" id="password" placeholder="Enter Password" class="input" name="password" required>
            <br>

            <button type="submit">Submit</button>
            <br>
            <div class="link">
               If you are not registerd then&ensp; <a href="./register.jsp" >Sign Up</a>
            </div>
        </form>
        <p id="message"></p>
    </div>
    <script src="js/main.js"></script>
</body>
</html>