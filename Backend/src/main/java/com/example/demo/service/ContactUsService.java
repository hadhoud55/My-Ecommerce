package com.example.demo.service;

import com.example.demo.entity.ContactUs;
import com.example.demo.repository.ContactUsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactUsService {

    private final ContactUsRepository contactUsRepository;

    public ContactUsService(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }

    // Save a new message
    public ContactUs saveMessage(ContactUs message) {
        return contactUsRepository.save(message);
    }

    // Retrieve all messages
    public List<ContactUs> getAllMessages() {
        return contactUsRepository.findAll();
    }

    // Retrieve a message by ID
    public ContactUs getMessageById(Long id) {
        return contactUsRepository.findById(id).orElse(null);
    }

    // Update a message by ID
    public ContactUs updateMessage(Long id, ContactUs updatedMessage) {
        ContactUs message = contactUsRepository.findById(id).orElse(null);
        if (message != null) {
            message.setName(updatedMessage.getName());
            message.setEmail(updatedMessage.getEmail());
            message.setMessage(updatedMessage.getMessage());
            return contactUsRepository.save(message);
        }
        return null;
    }

    // Delete a message by ID
    public boolean deleteMessage(Long id) {
        if (contactUsRepository.existsById(id)) {
            contactUsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
