<%@page import="com.E_Learning.model.AdmissionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group input[type="radio"] {
            width: auto;
        }
        .form-group .radio-group {
            display: flex;
            gap: 10px;
        }
        .form-group .terms {
            font-size: 12px;
            color: #777;
        }
        .form-group .note {
            font-size: 14px;
            color: #d9534f;
            margin-top: 10px;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #5cb85c;
            color: #fff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #4cae4c;
        }
    </style>
    
</head>
<body>
<%AdmissionBean bean=(AdmissionBean)request.getAttribute("bean");
	//out.print(bean.getPhone());
%>
   <div class="container">
        <h2> Update Admission Form</h2>
        
        
        <form  action="${pageContext.request.contextPath}/UpdateAddServlet" method="post">
            <div class="form-group">
                <label for="firstName">*First Name:</label>
                <input type="text" id="firstName" name="firstName" value=<%=bean.getFirstName()%>>
            </div>
            <div class="form-group">
                <label for="middleName">*Middle Name:</label>
                <input type="text" id="middleName" name="middleName" value=<%=bean.getMiddleName() %> >
            </div>
            <div class="form-group">
                <label for="lastName">*Last Name:</label>
                <input type="text" id="lastName" name="lastName" value=<%=bean.getLastName() %>>
            </div>
            <div class="form-group">
                <label for="mothersName">*Mother's Name:</label>
                <input type="text" id="mothersName" name="mothersName" value=<%=bean.getMothersName() %>>
            </div>
            <div class="form-group">
                <label for="address">*Permanent Address:</label>
                <textarea type="text" id="address" name="address"><%=bean.getAddress() %></textarea>
            </div>
           
            <div class="form-group">
                <label for="email">*Email ID:</label>
                <input type="email" id="email" name="email" value=<%=bean.getEmail()%>>
            </div>
            <div class="form-group">
                <label for="phone">*Phone Number:</label>
                <input type="tel" id="phone" name="phone" value=<%=bean.getPhone()%> readonly="readonly">
            </div>
            <div class="form-group">
                <label for="emergencyPhone">*Emergency Number:</label>
                <input type="tel" id="emergencyPhone" name="emergencyPhone" value=<%=bean.getEmergencyPhone() %>>
            </div>
            <div class="form-group">
                <label for="dob">*Date of Birth:</label>
                <input type="date" id="dob" name="dob" value=<%=bean.getDob() %>>
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <div class="radio-group">
                    <input type="radio" id="male" name="gender" value="Male">
                    <label for="male">Male</label>
                    <input type="radio" id="female" name="gender" value="Female">
                    <label for="female">Female</label>
                </div>
            </div>
            <div class="form-group">
                <label>*Batch Mode:</label>
                <div class="radio-group">
                    <input type="radio" id="online" name="batchMode" value="Online">
                    <label for="online">Online</label>
                    <input type="radio" id="offline" name="batchMode" value="Offline">
                    <label for="offline">Offline</label>
                </div>
            </div>
            <div class="form-group">
                <label for="course">*Std Applied for:</label>
                <select id="course" name="course">
                 <option value="0">Select From </option>
                    <option value="CA">CA </option>
                    <option value="CMA">CMA</option>
                    <option value="CS">CS </option>
                   <option value="CLAT">CLAT </option>
                    <option value="HSC">HSC</option>
                </select>
            </div>
          
            <div class="form-group">
                <p class="terms">*Terms and Conditions Apply.</p>
            </div>
            <div class="form-group">
                <button type="submit">UPDATE</button>
            </div>
        </form>
    </div>
</body>
</html>