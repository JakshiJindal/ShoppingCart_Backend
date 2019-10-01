package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.Exception.ResourceNotFound;
import com.caseStudy.eCart.models.products;
import com.caseStudy.eCart.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins="https://localhost:4200")
@RestController
@RequestMapping("/api")
public class productController {
    private productRepository productRepository;

    @Autowired
    public productController(productRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
    public List<products> getAllNotes() {
        return productRepository.findAll();
    }
    @PostMapping("/products")
    public products createNote(@Valid @RequestBody products note) {
        return productRepository.save(note);
    }
    @PutMapping("/products/{id}")
    public products updateNote(@PathVariable(value = "id") Long noteId,
                                  @Valid @RequestBody products noteDetails) {

        products note = productRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));

        note.setName(noteDetails.getName());
        note.setPrice((int) noteDetails.getPrice());

        products updatedNote = productRepository.save(note);
        return updatedNote;
    }
    @GetMapping("/products/{category}")
    public List<products> getProductByPrice(@PathVariable(value="category")String category)
    {
        return productRepository.findAllByCategory(category);
    }
    @GetMapping("/products/{price1}/between/{price2}")
    public List<products> getProductByPrice(@PathVariable(value="price1")double p,@PathVariable(value="price2")double p2)
    {
        return productRepository.findAllByPriceBetween(p,p2);
    }
}
