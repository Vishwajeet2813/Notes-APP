package com.example.notes.services;

import com.example.notes.models.Note;

public interface AuditLogService {

    public void logNoteCreation(String username, Note note);

    public void logNoteUpdation(String username, Note note);

    public void logNoteDeletion(String username, Note note);
}
