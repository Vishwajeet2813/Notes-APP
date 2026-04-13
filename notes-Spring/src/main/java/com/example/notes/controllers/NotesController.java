package com.example.notes.controllers;

import com.example.notes.models.Note;
import com.example.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody Map<String, String> payload, @AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        String content = payload.get("content");
        return noteService.createNoteForUser(username, content);
    }

    @GetMapping
    public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        return noteService.getNotesForUser(username);
    }

    @PutMapping("/{noteId}")
    public Note upateNote(@PathVariable Long noteId, @RequestBody Map<String, String> payload, @AuthenticationPrincipal UserDetails userDetails){
        String content = payload.get("content");
        Note updateNote = noteService.updateNoteForUser(noteId, content, userDetails.getUsername());
        return updateNote;
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails){
        noteService.deleteNoteForUser(noteId, userDetails.getUsername());
    }
}
