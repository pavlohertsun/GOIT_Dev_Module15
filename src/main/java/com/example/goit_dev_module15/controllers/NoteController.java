package com.example.goit_dev_module15.controllers;

import com.example.goit_dev_module15.dtos.NoteDto;
import com.example.goit_dev_module15.services.NoteService;
import com.example.goit_dev_module15.utils.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ModelAndView getNotesList(){
        ModelAndView modelAndView = new ModelAndView("notes/all_notes");
        modelAndView.addObject("notes", noteService.getAllNotes());
        return modelAndView;
    }
    @GetMapping("/createPage")
    public ModelAndView getCreatePage(){
        return new ModelAndView("notes/create_page");
    }

    @GetMapping("/update")
    public ModelAndView getUpdateNotePage(@RequestParam long id) throws Exception{
        ModelAndView modelAndView = new ModelAndView("notes/update_page");
        modelAndView.addObject("note", noteService.getNoteById(id));
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView updateNote(@RequestParam long id,
                                   @RequestParam String title,
                                   @RequestParam String content) throws Exception{
        NoteDto noteDto = new NoteDto(id, title, content);
        noteService.updateNote(noteDto);

        return getNotesList();
    }
    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam long id) throws Exception{
        noteService.deleteNote(id);
        return getNotesList();
    }
    @PostMapping("/create")
    public ModelAndView createNote(@RequestParam String title,
                                   @RequestParam String content){
        NoteDto noteDto = new NoteDto();
        noteDto.setTitle(title);
        noteDto.setContent(content);
        noteService.createNote(noteDto);

        return getNotesList();
    }
}
