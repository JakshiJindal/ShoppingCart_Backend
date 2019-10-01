package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.Exception.ResourceNotFound;
import com.caseStudy.eCart.models.userDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.caseStudy.eCart.repository.userDetailsRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class userDetailsController {
@Autowired
    userDetailsRepository p;
    @GetMapping("/userDetails/{id}")
    public userDetails getNoteById(@PathVariable(value = "id") Long userId) {
        return p.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", userId));
    }
    @PostMapping("/userDetails")
    public userDetails createNote(@Valid @RequestBody userDetails note) {
        return p.save(note);
    }
    @PutMapping("/user/{id}")
    public userDetails updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody userDetails noteDetails) {

        userDetails note = p.findById(noteId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));

        note.setUsername(noteDetails.getUsername());
        note.setPassword(noteDetails.getPassword());

        userDetails updatedNote = p.save(note);
        return updatedNote;
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        userDetails note = p.findById(noteId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));
        p.delete(note);

        return ResponseEntity.ok().build();
    }
}
