
package com.caseStudy.eCart.controller;

        import com.caseStudy.eCart.Exception.ResourceNotFound;
        import com.caseStudy.eCart.models.users;
        import com.caseStudy.eCart.service.CurrentUserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import com.caseStudy.eCart.repository.UsersRepository;

        import javax.validation.Valid;
        import java.security.Principal;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")

class userController {
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    private UsersRepository p;

    @GetMapping("/userss/{id}")
    public users getUserId(@PathVariable(value = "id") Long userId) {
        return p.findByUserid(userId);
               // .orElseThrow(() -> new ResourceNotFound("Note", "id", userId));
    }
    @GetMapping("/userss")
    public users getUser(Principal principal) {
        return p.findByUserid(currentUserService.getUserId(principal));
        // .orElseThrow(() -> new ResourceNotFound("Note", "id", userId));
    }
    @GetMapping("/users/{username}")
    public users findByUsername(@PathVariable(value = "username") String username) {
        return p.findByUsername(username).get();
                //.orElseThrow(() -> new ResourceNotFound("Note", "username", username));
    }
    @GetMapping("/usersRole/{role}")
    public users findByRole(@PathVariable(value = "role") String role) {
        return p.findByRole(role)
                .orElseThrow(() -> new ResourceNotFound("Note", "username", role));
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
