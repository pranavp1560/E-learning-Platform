<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="java.util.List" %>
<%@ page import="com.E_Learning.model.AdmissionBean" %>
<%@ page import="com.E_Learning.dao.ConnectionDao" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.E_Learning.dao.ConnectionDao" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles.css">
    <style>
    /* Reset styles for basic layout */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: Arial, sans-serif;
    line-height: 1.6;
    background-color: #f0f0f0;
}

header {
    background-color: #333;
    color: #fff;
    padding: 1rem;
    text-align: center;
}

header h1 {
    margin-bottom: 0.5rem;
}

nav ul {
    list-style-type: none;
}

nav ul li {
    display: inline;
    margin-right: 1rem;
}

nav ul li a {
    color: #fff;
    text-decoration: none;
    padding: 0.5rem;
}

main {
    padding: 2rem;
}

.summary {
    display: flex;
    justify-content: space-around;
    margin-bottom: 2rem;
    flex-wrap: wrap;
}

.summary-card {
    background-color: #fff;
    padding: 1rem;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    text-align: center;
    flex: 1;
   
}

.analytics {
    background-color: #fff;
    padding: 1rem;
    margin-bottom: 2rem;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

.users {
    background-color: #fff;
    padding: 1rem;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 1rem;
}

table th, table td {
    padding: 0.5rem;
    border: 1px solid #ccc;
    text-align: left;
}
table th{
    font-size:10px;
}
table td
{
    font-size:8px;
}
footer {
    text-align: center;
    padding: 1rem;
    background-color: #333;
    color: #fff;
    position: fixed;
    bottom: 0;
    width: 100%;
}
    
    </style>
    
</head>
<body>
    <header>
        <h1 style="color:#F0FCF3">Admin Dashboard</h1>
        <nav>
            <ul>
                <li><a href="#">Analytics</a></li>
                <li><a href="#">Users</a></li>
                <li><a href="#">Courses</a></li>
                <li><a href="#">Settings</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="summary">
            <div class="summary-card">
                <h2>Total Users</h2>
                 <p>
                    <%
                        int totalUsers = 0;
                        try {
                            ConnectionDao cd = new ConnectionDao();
                            Connection con = cd.getConnection(); // Ensure this is the correct method to get the connection
                            
                            String sql = "SELECT COUNT(*) FROM admission";
                            PreparedStatement stmt = con.prepareStatement(sql);
                            ResultSet rs = stmt.executeQuery();

                            if (rs.next()) {
                                totalUsers = rs.getInt(1);
                            }

                            rs.close();
                            stmt.close();
                            con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                    <%= totalUsers %>
                </p>
            </div>
            <div class="summary-card">
                <h2>Total Courses</h2>
                <p>5</p>
            </div>
            <div class="summary-card">
                <h2>Total Revenue</h2>
           <p>₹ 1000000</p>
            </div>
        </section>
        <section class="summary">
        <div class="summary-card">
            <form action="StudentsViewServlet" method="post" name="fee" id="fee">               
                  <h2>View students</h2>
                    <label for="course">View Course</label>
                    <select id="course" name="course" onchange="this.form.submit()">
                    <option value="0" >select</option>
                        <option value="CA" >CA</option>
                        <option value="CMA">CMA</option>
                        <option value="CS">CS</option>
                        <option value="CLAT">CLAT</option>
                        <option value="HSC">HSC</option>
                    </select>               
            </form>
            </div> 
            <div class="summary-card">
             <form action="${pageContext.request.contextPath}/UpdateServlet" method="post"  id="update">        
                <h2>Update Students</h2>
                <input type=text placeholder="enter mobile number" name="phone">
                <input type="submit" value="Update" >
                
             </form >  
            </div>
             <div class="summary-card">
             <form action="${pageContext.request.contextPath}/DeleteStudentServlet" method="post"  id="delete">        
                <h2>Delete Students</h2>
                <input type=text placeholder="enter mobile number" name="phone">
                <input type="submit" value="Delete">
                
             </form >  
            </div>
        </section>

  

        <section class="users">
            <%String selectedCourse = (String) request.getAttribute("course"); %>
            
            	
            
            <h3> <%= selectedCourse %> Students</h3>
            <table>
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Middle Name</th>
                        <th>Last Name</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Emergency Phone</th>
                        <th>Date of Birth</th>
                        <th>Gender</th>
                        <th>Batch Mode</th>
                        <th>Fee</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<AdmissionBean> students = (List<AdmissionBean>) request.getAttribute("students");
                        if (students != null) {
                            for (AdmissionBean student : students) {
                    %>
                    <tr>
                        <td><%= student.getFirstName() %></td>
                        <td><%= student.getMiddleName() %></td>
                        <td><%= student.getLastName() %></td>
                        <td><%= student.getAddress() %></td>
                        <td><%= student.getEmail() %></td>
                        <td><%= student.getPhone() %></td>
                        <td><%= student.getEmergencyPhone() %></td>
                        <td><%= student.getDob() %></td>
                        <td><%= student.getGender() %></td>
                        <td><%= student.getBatchMode() %></td>
                        <td><%= student.getFees() %></td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="10">No students found for the selected course.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 E-Learning Website. All rights reserved.</p>
    </footer>
</body>
</html>