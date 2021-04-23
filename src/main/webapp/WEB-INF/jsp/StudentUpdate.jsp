<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<h2>Updating Student Details</h2>
    <c:url var="updateaction" value="/updateStu" />
    <form:form action="${updateaction }" method="post"
        modelAttribute="editForm">
        <table>
            <tr>
                <th>Student Id:</th>
                <td><form:input type="text" path="studentid" readonly="true" /></td>
            </tr>
            <tr>
                <th>Name:</th>
                <td><form:input type="text" path="name" /><font color="red"><form:errors path="name"/></font></td>
            </tr>
            <tr>
                <th>Age:</th>
                <td><form:input type="text" path="age" readonly="true" /></td>
            </tr>
            <tr>
                <th>Address:</th>
                <td><form:input type="text" path="address" /><font color="red"><form:errors path="address"/></font></td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td><form:radiobutton  path="gender" value="male" onclick="return false" />Male
                <form:radiobutton path="gender" value="female" onclick="return false" />Female
                </td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td><form:input type="date" path="dob" /><font color="red"><form:errors path="doj"/></font></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><form:input type="text" path="email" /><font color="red"><form:errors path="email"/></font></td>
            </tr>
            <tr>
                
                <td><input type="submit" value="Update Student" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>