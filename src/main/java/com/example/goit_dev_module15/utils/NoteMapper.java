package com.example.goit_dev_module15.utils;

import com.example.goit_dev_module15.dtos.NoteDto;
import com.example.goit_dev_module15.entities.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoteMapper {
    public static List<NoteDto> toNoteDtoList(List<Note> notes){
        List<NoteDto> result = new ArrayList<>();

        notes.stream().forEach(n -> {
            NoteDto noteDto = new NoteDto();
            noteDto.setId(n.getId());
            noteDto.setTitle(n.getTitle());
            noteDto.setContent(n.getContent());
            result.add(noteDto);
        });

        return result;
    }
    public static NoteDto toNoteDto(Note note){
        return new NoteDto(note.getId(), note.getTitle(), note.getContent());
    }
    public static Note toNoteEntity(NoteDto noteDto){
        return new Note(noteDto.getId(), noteDto.getTitle(), noteDto.getContent());
    }
}
