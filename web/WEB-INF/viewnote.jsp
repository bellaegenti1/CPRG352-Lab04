<%-- 
    Document   : viewnote
    Created on : 10-Oct-2021, 10:24:44 AM
    Author     : @bellaegenti1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
     
        <h2>View Note</h2>
        <p>Title</p>
        <p>${note.title}</p>

        <p>Content</p>
        <p>${note.content}</p>
             

        <a href="note?edit">Edit</a>
    </body>
</html>