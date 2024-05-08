package com.example.goit_dev_module15.repositories;

import com.example.goit_dev_module15.entities.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class NoteRepositoryTest {
    private NoteRepository noteRepository;

    @BeforeEach
    void init(){
        noteRepository = new NoteRepository();
        noteRepository.init();
    }

    @Test
    void listAllTest() {
        List<Note> expectedList = new ArrayList<>();

        expectedList.add(new Note(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street"));
        expectedList.add(new Note(2, "Grocery Shopping", "Time: After Work, List: Milk, Eggs, Bread, Fruits"));
        expectedList.add(new Note(3, "Meeting with Project Team", "Time: 2:00 PM, Location: Conference Room B"));
        expectedList.add(new Note(4, "Call Mom for Her Birthday", "Time: Evening, Gift: Flowers and Card"));
        expectedList.add(new Note(5, "Gym Session", "Time: 6:00 PM, Activity: Cardio and Strength Training"));

        List<Note> actualList = noteRepository.listAll();

        Assertions.assertIterableEquals(expectedList, actualList);
    }

    @Test
    void addTest() {
        Note expected = new Note(6, "Test note", "Test note content");

        Note actual = noteRepository.add(expected);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteByIdTest() {
        Assertions.assertDoesNotThrow(() -> noteRepository.deleteById(3L));
    }
    @Test
    void deleteByNotExistingIdTest() {
        Assertions.assertThrows(Exception.class, () -> noteRepository.deleteById(7L));
    }

    @Test
    void updateTest() throws Exception{
        List<Note> expectedList = new ArrayList<>();

        expectedList.add(new Note(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street"));
        expectedList.add(new Note(2, "Grocery Shopping", "Time: After Work, List: Milk, Eggs, Bread, Fruits"));
        expectedList.add(new Note(3, "Test note update", "Time: 2:00 PM, Location: Conference Room B"));
        expectedList.add(new Note(4, "Call Mom for Her Birthday", "Time: Evening, Gift: Flowers and Card"));
        expectedList.add(new Note(5, "Gym Session", "Time: 6:00 PM, Activity: Cardio and Strength Training"));

        noteRepository.update(new Note(3, "Test note update", "Time: 2:00 PM, Location: Conference Room B"));

        List<Note> actualList = noteRepository.listAll();

        Assertions.assertIterableEquals(expectedList, actualList);
    }

    @Test
    void updateNotExistingNote(){
        Assertions.assertThrows(Exception.class, () -> noteRepository.update(new Note(7, "Test note update", "Time: 2:00 PM, Location: Conference Room B")));
    }

    @Test
    void getByIdTest() throws Exception{
        Note expectedNote = new Note(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street");

        Note actualNote = noteRepository.getById(1L);

        Assertions.assertEquals(expectedNote, actualNote);
    }

    @Test
    void getNotExistingNote(){
        Assertions.assertThrows(Exception.class, () -> noteRepository.getById(10L));
    }
}
