package com.example.goit_dev_module15.utils;

import com.example.goit_dev_module15.entities.Note;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class FileReader {
    public static List<Note> readNotesFromFile(){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            File file = new File("src/main/resources/data/notes.json");
            if (!file.exists()) {
                System.out.println("File not found.");
                return Collections.emptyList();
            }

            return objectMapper.readValue(file, new TypeReference<List<Note>>() {});
        } catch (IOException ex){
            System.out.println("Error while reading from file, reason:" + ex.getMessage());
            return Collections.emptyList();
        }
    }
}
