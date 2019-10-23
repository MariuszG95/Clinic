<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <table style="width: 100%">
        <tr bgcolor="#6495ed">
            <td align="center"><h1><font color="white">Klinika</font></h1></td>
            <%
                try {
                    String string = request.getUserPrincipal().getName();
                    %>
            <td align="right"><a href="/visits">Moje wizyty</a> <a href="/logout">Wyloguj</a></td>
            <%
                } catch (NullPointerException npe) {
                    %>
            <td align="right"><a href="/login">Zaloguj</a> <a href="/register">Rejestracja</a></td>
            <%
                }
            %>
        </tr>
        <tr bgcolor="#7fffd4">
            <td colspan="2">
                <a href="/home">Strona główna</a>
            </td>
        </tr>
    </table>
</div>