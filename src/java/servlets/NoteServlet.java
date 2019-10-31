/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import services.NoteService;

/**
 *
 * @author 745507
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("action", "add");
        setNotes(request);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        NoteService noteService = new NoteService();
        
        if (action != null && action.equals("edit")) {
            
            int noteID = Integer.parseInt(request.getParameter("noteid"));
            Note noteToEdit = noteService.get(noteID);
            
            request.setAttribute("action", "edit");
            request.setAttribute("noteToEdit", noteToEdit);
        } else if (action != null && action.equals("delete")) {
            
            int noteID = Integer.parseInt(request.getParameter("noteid"));
            
            noteService.delete(noteID);
            request.setAttribute("action", "add");
        } else if (action != null && action.equals("add")) {
            String noteTitle = request.getParameter("noteTitleInput");
            String noteContents = request.getParameter("noteContentsInput");
            
            noteService.insert(noteContents, noteTitle);
            request.setAttribute("action", "add");
        } else if (action != null && action.equals("save")) {
            try {
                int noteID = Integer.parseInt(request.getParameter("noteid"));
                String noteTitle = request.getParameter("noteTitleInput");
                String noteContents = request.getParameter("noteContentsInput");
                
                noteService.update(noteID, noteTitle, noteContents);
                request.setAttribute("action", "add");
            } catch (Exception e) {
                request.setAttribute("error", e.getMessage());
            }
        }
        
        setNotes(request);
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }
    
    private void setNotes(HttpServletRequest request) {
        try {
            NoteService noteService = new NoteService();
            request.setAttribute("notes", noteService.getAll());
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
}
