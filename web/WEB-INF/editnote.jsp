<%-- 
    Document   : editnote
    Created on : 10-Oct-2021, 10:20:26 AM
    Author     : @bellaegenti1
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <form method="post" action="note" >

           
            <p>Title</p>
            <textarea name="Title" > ${note.title}</textarea>
            <br>
            <p>Content</p>
            <textarea name="Content"> ${note.content}</textarea>
            <br>
            <br>
            <br>
            <input type="submit" value="Save"> </input>
        </form>


    </body>
</html>