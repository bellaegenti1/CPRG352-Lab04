package servlets;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.Note;

/**
 *
 * @author bellaegent1
 */
public class NoteServlet extends HttpServlet {

    Note note;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        note = readNoteFromFile();

        request.setAttribute("note", note);

        String edit = request.getParameter("edit");
        if (edit != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);

        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        String title = request.getParameter("Title");
        String content = request.getParameter("Content");
        Note note = new Note(title, content);
        
         request.setAttribute("note", note);
        writeEditedNoteToFile(note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    private Note readNoteFromFile() throws IOException, FileNotFoundException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader buffR = new BufferedReader(new FileReader(new File(path)));
        String title = buffR.readLine();
        String content = buffR.readLine();
        buffR.close();
        Note note = new Note(title, content);
        return note;
    }

    private void writeEditedNoteToFile(Note note) {

        String PATH = getServletContext().getRealPath("/WEB-INF/note.txt");
        try {

            File writer = new File(PATH);
            PrintWriter save = new PrintWriter(writer);

            save.println(note.getTitle());
            save.println(note.getContent());

            save.close();
        } catch (IOException ex) {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
