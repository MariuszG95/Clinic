<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Strona główna</title>
</head>
<body>
    <jsp:include page="elements/menu.jsp"/>

    <h1>Wyszukaj interesującego Cię doktora wpisując jego imię, nazwisko lub specjalizację:</h1>
    <form method="post">
        <input type="text" name="search" width="80%" align="center"> <input type="submit" value="Szukaj">
    </form>
    <c:if test="${doctorsFound.size() > 0}">
        <table align="center" border="1">
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Specjalizacja</th>
                <th>Więcej</th>
            </tr>
            <c:forEach items="${doctorsFound}" var="doctor">
                <tr>
                    <td>${doctor.userDTO.firstName}</td>
                    <td>${doctor.userDTO.lastName}</td>
                    <td>
                        <c:forEach items="${doctor.specializations}" var="specialization" varStatus="status">
                            ${specialization.name}<c:if test="${!status.last}">, </c:if>
                        </c:forEach>
                    </td>
                    <td><a href="/doctor/${doctor.id}">Link</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${doctorsFound.size() == 0}">
        <p>Brak wyników wyszuikwania. Spróbuj użyć innych słów kluczowych.</p>
    </c:if>
</body>
</html>
