package services;

import models.Note;
import dataaccess.NoteDB;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 745507
 */
public class NoteService {
    
    public Note get(int noteid) {
        NoteDB db = new NoteDB();
        Note note = db.get(noteid);
        return note;
    }
    
    public List<Note> getAll() throws Exception {
        NoteDB db = new NoteDB();
        return(db.getAll());
    }
    
    public void update(int noteid, String title, String contents) throws Exception {
        NoteDB db = new NoteDB();
        Date date = db.get(noteid).getDatecreated();
        Note note = new Note(noteid, date, title, contents);
        
        db.update(note);
    }
    
    public void delete(int noteid) {
        NoteDB db = new NoteDB();
        Note note = db.get(noteid);
        db.delete(note);
    }
    
    public void insert(String contents, String title) {
        NoteDB db = new NoteDB();
        
        Note note = new Note(0, new Date(), title, contents);
        db.insert(note);
    }
    
    
    
}
