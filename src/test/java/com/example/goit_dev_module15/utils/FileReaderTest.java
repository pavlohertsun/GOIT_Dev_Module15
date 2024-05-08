package com.example.goit_dev_module15.utils;

import com.example.goit_dev_module15.entities.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FileReaderTest {

    @Test
    void readNotesFromFileTest() {
        List<Note> expectedList = new ArrayList<>();

        expectedList.add(new Note(1, "Appointment with Dentist", "Time: 10:00 AM, Location: Dental Clinic, 123 Main Street"));
        expectedList.add(new Note(2, "Grocery Shopping", "Time: After Work, List: Milk, Eggs, Bread, Fruits"));
        expectedList.add(new Note(3, "Meeting with Project Team", "Time: 2:00 PM, Location: Conference Room B"));
        expectedList.add(new Note(4, "Call Mom for Her Birthday", "Time: Evening, Gift: Flowers and Card"));
        expectedList.add(new Note(5, "Gym Session", "Time: 6:00 PM, Activity: Cardio and Strength Training"));

        List<Note> actualList = FileReader.readNotesFromFile();

        Assertions.assertIterableEquals(expectedList, actualList);
    }
}
