package com.example.notes.controllers;

import com.example.notes.models.AuditLog;
import com.example.notes.services.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping
    public List<AuditLog> getAuditLogs(){
        return auditLogService.getAllAudits();
    }

    @GetMapping("/note/{noteId}")
    public List<AuditLog> getNoteAuditLogs(@PathVariable Long noteId){
        return auditLogService.getAllAuditForNote(noteId);
    }
}
