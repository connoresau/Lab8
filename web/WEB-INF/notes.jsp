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
        <table class="notesTable">
            <tr><th>Date Created</th><th>Title</th></tr>
                    <c:forEach items="${notes}" var="note">
                <tr><td>${note.datecreated}</td><td>${note.title}</td><td>
                        <form action="notes?action=edit&noteid=${note.noteid}" method="post">
                            <input type="submit" value="Edit" name="notesToEdit">
                        </form>
                    </td></tr>
                </c:forEach>
        </table>

        <c:if test="${action == 'add'}">
            <h1>Add Note</h1>
            <form action="notes?action=add" method="post">
                <input type="text" style="width: 350px;" name="noteTitleInput" placeholder="title" id="noteInput"><br>
                <textarea placeholder="type a note..." name="noteContentsInput" rows="10" cols="50" style="resize: none;"></textarea><br>
                <input type="submit" value="Add">
            </form>
        </c:if>
        <c:if test="${action == 'edit'}">
            <h1>Edit Note</h1>
            <form action="notes?action=delete&noteid=${noteToEdit.noteid}" method="post">
                <input type="submit" value="Delete note">
            </form><br>
            <form action="notes?action=save&noteid=${noteToEdit.noteid}" method="post">
                <input type="text" style="width: 350px;" placeholder="title" name="noteTitleInput" value="${noteToEdit.title}"><br>
                <textarea placeholder="type a note..." name="noteContentsInput" rows="10" cols="50" style="resize: none;">${noteToEdit.contents}</textarea><br>
                <input type="submit" value="Save">
            </form>
        </c:if>
            

        ${error}
    </body>
</html>
