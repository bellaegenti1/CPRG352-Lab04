package servlets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author bellaegent1
 */

@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {

    Note note;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // note = readNoteFromFile();

     

        String mod = request.getParameter("edit");
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();
        Note note = new Note(title, content);
        request.setAttribute("note", note);
      
        if (mod == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }  

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("Title");
        String content = request.getParameter("Content");
        Note note = new Note(title, content);
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(title);
        pw.println(content);
        pw.close();
        
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    }
/**
    private Note readNoteFromFile() throws IOException, FileNotFoundException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();
        br.close();
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

    } **/
}
