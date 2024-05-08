package com.example.goit_dev_module15.utils;

import com.example.goit_dev_module15.dtos.NoteDto;
import com.example.goit_dev_module15.entities.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NoteMapperTest {

    @Test
    void toNoteDtoListTest() {
        List<NoteDto> expectedList = new ArrayList<>();

        expectedList.add(new NoteDto(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street"));
        expectedList.add(new NoteDto(2, "Grocery Shopping", "Time: After Work, List: Milk, Eggs, Bread, Fruits"));
        expectedList.add(new NoteDto(3, "Meeting with Project Team", "Time: 2:00 PM, Location: Conference Room B"));
        expectedList.add(new NoteDto(4, "Call Mom for Her Birthday", "Time: Evening, Gift: Flowers and Card"));
        expectedList.add(new NoteDto(5, "Gym Session", "Time: 6:00 PM, Activity: Cardio and Strength Training"));

        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street"));
        notes.add(new Note(2, "Grocery Shopping", "Time: After Work, List: Milk, Eggs, Bread, Fruits"));
        notes.add(new Note(3, "Meeting with Project Team", "Time: 2:00 PM, Location: Conference Room B"));
        notes.add(new Note(4, "Call Mom for Her Birthday", "Time: Evening, Gift: Flowers and Card"));
        notes.add(new Note(5, "Gym Session", "Time: 6:00 PM, Activity: Cardio and Strength Training"));

        List<NoteDto> actualList = NoteMapper.toNoteDtoList(notes);

        Assertions.assertIterableEquals(expectedList, actualList);
    }

    @Test
    void toNoteDtoTest() {
        Note note = new Note(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street");

        NoteDto expected = new NoteDto(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street");

        NoteDto actual = NoteMapper.toNoteDto(note);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void toNoteEntityTest() {
        NoteDto noteDto = new NoteDto(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street");

        Note expected = new Note(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street");

        Note actual = NoteMapper.toNoteEntity(noteDto);

        Assertions.assertEquals(expected, actual);
    }
}
