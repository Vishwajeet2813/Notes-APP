package com.example.notes.servicesImpl;

import com.example.notes.models.Note;
import com.example.notes.services.AuditLogService;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Override
    public void logNoteCreation(String username, Note note){

    }

    @Override
    public void logNoteUpdation(String username, Note note){

    }

    @Override
    public void logNoteDeletion(String username, Note note){

    }

}
