package com.example.demo.controller;

import com.example.demo.entity.ContactUs;
import com.example.demo.service.ContactUsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactUsController {

    private final ContactUsService contactUsService;

    public ContactUsController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }

    // Endpoint to save a contact message
    @PostMapping("/messages")
    public ResponseEntity<ContactUs> saveMessage(@RequestBody ContactUs message) {
        ContactUs savedMessage = contactUsService.saveMessage(message);
        return ResponseEntity.ok(savedMessage);
    }

    // Endpoint to get all contact messages
    @GetMapping("/messages")
    public ResponseEntity<List<ContactUs>> getAllMessages() {
        List<ContactUs> messages = contactUsService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    // Endpoint to get a message by ID
    @GetMapping("/messages/{id}")
    public ResponseEntity<ContactUs> getMessageById(@PathVariable Long id) {
        ContactUs message = contactUsService.getMessageById(id);
        if (message != null) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint to update a message by ID
    @PutMapping("/messages/{id}")
    public ResponseEntity<ContactUs> updateMessage(@PathVariable Long id, @RequestBody ContactUs updatedMessage) {
        ContactUs message = contactUsService.updateMessage(id, updatedMessage);
        if (message != null) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint to delete a message by ID
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        if (contactUsService.deleteMessage(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
