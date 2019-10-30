<%-- 
    Document   : notes
    Created on : Oct 29, 2019, 9:40:31 AM
    Author     : 745507
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes!</title>
        <link rel="stylesheet" href="/css/notes.css">
    </head>
    <body>
        <h1>Notes!</h1>
        <form>
            <table id="notesTable">
                <tr><th>Date Created</th><th>Title</th></tr>
                        <c:forEach items="${notes}" var="note">
                    <tr><td>${note.datecreated}</td><td>${note.title}</td><td><input type="submit" value="Edit"></td></tr>
                        </c:forEach>
            </table>
        </form>
        <h1>Edit Note</h1>
        ${error}
    </body>
</html>
