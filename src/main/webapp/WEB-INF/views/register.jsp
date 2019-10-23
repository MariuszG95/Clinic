<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
    <div>
        <jsp:include page="elements/menu.jsp"/>
        <div>
            <h2>Rejestracja nowego użytkownika</h2>
            <form:form method="post" modelAttribute="registerFormDTO">
                <table>
                    <tr>
                        <td>Login</td>
                        <td><form:input path="login" /></td>
                        <td><form:errors path="login" /></td>
                        <td><font color="red">${registerFormDTO.errors.get("login")}</font></td>
                    </tr>
                    <tr>
                        <td>eMail</td>
                        <td><form:input path="email" /></td>
                        <td><font color="red">${registerFormDTO.errors.get("email")}</font></td>
                    </tr>
                    <tr>
                        <td>Imię</td>
                        <td><form:input path="firstName" /></td>
                        <td><font color="red">${registerFormDTO.errors.get("firstName")}</font></td>
                    </tr>
                    <tr>
                        <td>Nazwisko</td>
                        <td><form:input path="lastName" /></td>
                        <td><font color="red">${registerFormDTO.errors.get("lastName")}</font></td>
                    </tr>
                    <tr>
                        <td>Data urodzenia (DD-MM-YYYY)</td>
                        <td><form:input path="stringBirthDate" /></td>
                        <td><font color="red">${registerFormDTO.errors.get("birthDate")}</font></td>
                    </tr>
                    <tr>
                        <td>Hasło</td>
                        <td><form:password path="password" /></td>
                        <td><font color="red">${registerFormDTO.errors.get("password")}</font></td>
                    </tr>
                    <tr>
                        <td>Powtórzone hasło</td>
                        <td><form:password path="repeatedPassword" /></td>
                        <td><font color="red">${registerFormDTO.errors.get("repeatedPassword")}</font></td>
                    </tr>
                </table>
                <input type="submit" value="Zarejestruj się">
            </form:form>
        </div>
    </div>
</body>
</html>