package com.example.goit_dev_module15.services;

import com.example.goit_dev_module15.dtos.NoteDto;
import com.example.goit_dev_module15.entities.Note;
import com.example.goit_dev_module15.repositories.NoteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceTest {

    private NoteService noteService;
    @BeforeEach
    void init(){
        NoteRepository noteRepository = new NoteRepository();
        noteRepository.init();
        noteService = new NoteService(noteRepository);
    }

    @Test
    void getAllNotesTest() {
        List<NoteDto> expectedList = new ArrayList<>();

        expectedList.add(new NoteDto(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street"));
        expectedList.add(new NoteDto(2, "Grocery Shopping", "Time: After Work, List: Milk, Eggs, Bread, Fruits"));
        expectedList.add(new NoteDto(3, "Meeting with Project Team", "Time: 2:00 PM, Location: Conference Room B"));
        expectedList.add(new NoteDto(4, "Call Mom for Her Birthday", "Time: Evening, Gift: Flowers and Card"));
        expectedList.add(new NoteDto(5, "Gym Session", "Time: 6:00 PM, Activity: Cardio and Strength Training"));

        List<NoteDto> actualList = noteService.getAllNotes();

        Assertions.assertIterableEquals(expectedList, actualList);
    }

    @Test
    void getNoteByIdTest() throws Exception{
        NoteDto expected = new NoteDto(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street");

        NoteDto actual = noteService.getNoteById(1L);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getNotExistingNote(){
        Assertions.assertThrows(Exception.class, () -> noteService.getNoteById(10L));
    }

    @Test
    void createNoteTest() {
        NoteDto expected = new NoteDto(6, "Test note", "Test note content");

        NoteDto noteDtoToAdd = new NoteDto();
        noteDtoToAdd.setTitle("Test note");
        noteDtoToAdd.setContent("Test note content");


        NoteDto actual = noteService.createNote(noteDtoToAdd);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteNoteTest() {
        Assertions.assertDoesNotThrow(() -> noteService.deleteNote(3L));
    }
    @Test
    void deleteByNotExistingIdNoteTest() {
        Assertions.assertThrows(Exception.class, () -> noteService.deleteNote(7L));
    }

    @Test
    void updateNoteTest() throws Exception{
        List<NoteDto> expectedList = new ArrayList<>();

        expectedList.add(new NoteDto(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street"));
        expectedList.add(new NoteDto(2, "Grocery Shopping", "Time: After Work, List: Milk, Eggs, Bread, Fruits"));
        expectedList.add(new NoteDto(3, "Test note update", "Time: 2:00 PM, Location: Conference Room B"));
        expectedList.add(new NoteDto(4, "Call Mom for Her Birthday", "Time: Evening, Gift: Flowers and Card"));
        expectedList.add(new NoteDto(5, "Gym Session", "Time: 6:00 PM, Activity: Cardio and Strength Training"));

        noteService.updateNote(new NoteDto(3, "Test note update", "Time: 2:00 PM, Location: Conference Room B"));

        List<NoteDto> actualList = noteService.getAllNotes();

        Assertions.assertIterableEquals(expectedList, actualList);
    }
    @Test
    void updateNotExistingNote(){
        Assertions.assertThrows(Exception.class, () -> noteService.updateNote(new NoteDto(7, "Test note update", "Time: 2:00 PM, Location: Conference Room B")));
    }

}