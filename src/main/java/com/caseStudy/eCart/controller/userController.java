
package com.caseStudy.eCart.controller;

        import com.caseStudy.eCart.Exception.ResourceNotFound;
        import com.caseStudy.eCart.models.users;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import com.caseStudy.eCart.repository.UsersRepository;

        import javax.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")

class userController {
    @Autowired
    UsersRepository p;
    @GetMapping("/users/{id}")
    public users getUserId(@PathVariable(value = "id") Long userId) {
        return p.findByUserid(userId);
               // .orElseThrow(() -> new ResourceNotFound("Note", "id", userId));
    }
    @GetMapping("/users/{username}")
    public users findByUsername(@PathVariable(value = "username") String username) {
        return p.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFound("Note", "username", username));
    }
    @PostMapping("/users")
    public users createUser(@Valid @RequestBody users note) {
        return p.save(note);
    }
    @PutMapping("/user/{id}")
    public users updateUser(@PathVariable(value = "id") Long noteId,
                            @Valid @RequestBody users noteDetails) {

        users note = p.findByUserid(noteId);
                //.orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));

        note.setUsername(noteDetails.getUsername());
        note.setPassword(noteDetails.getPassword());
        note.setActive(noteDetails.getActive());
        note.setRole(noteDetails.getRole());
        users updatedNote = p.save(note);
        return updatedNote;
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        users note = p.findByUserid(noteId);
                //.orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));
        p.delete(note);

        return ResponseEntity.ok().build();
    }


}
