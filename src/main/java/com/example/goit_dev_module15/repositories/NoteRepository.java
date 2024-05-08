package com.example.goit_dev_module15.repositories;

import com.example.goit_dev_module15.entities.Note;
import com.example.goit_dev_module15.utils.FileReader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {
    private List<Note> notes;

    @PostConstruct
    public void init(){
        notes = FileReader.readNotesFromFile();
    }

    public List<Note> listAll(){
        return notes;
    }
    public Note add(Note note){
        notes.add(note);
        return note;
    }
    public void deleteById(long id) throws Exception{
        Optional<Note> noteToRemove = notes.stream().filter(n -> n.getId() == id).findFirst();

        if(noteToRemove.isPresent()){
            notes.remove(noteToRemove.get());
        }
        else {
            System.out.println("Note with id#" + id + " not found.");
            throw new Exception();
        }
    }
    public void update(Note note) throws Exception{
        Optional<Note> noteToUpdate = notes.stream().filter(n -> n.getId() == note.getId()).findFirst();

        if(noteToUpdate.isPresent()){
            notes.forEach(n -> {
                if(n.getId() == noteToUpdate.get().getId()){
                    n.setTitle(note.getTitle());
                    n.setContent(note.getContent());
                }
            });
        }
        else {
            System.out.println("Note with id#" + note.getId() + " not found.");
            throw new Exception();
        }

    }
    public Note getById(long id) throws Exception{
        Optional<Note> noteToReturn = notes.stream().filter(n -> n.getId() == id).findFirst();

        if(noteToReturn.isPresent()){
            return noteToReturn.get();
        }
        else {
            System.out.println("Note with id#" + id + " not found.");
            throw new Exception();
        }
    }
}
