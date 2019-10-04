package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.Exception.ResourceNotFound;
import com.caseStudy.eCart.models.products;
import com.caseStudy.eCart.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class productController {
    private productRepository productRepository;

    @Autowired
    public productController(productRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
    public List<products> getProducts() {
        return productRepository.findAll();
    }
    @PostMapping("/products")
    public products createProducts(@Valid @RequestBody products note) {
        return productRepository.save(note);
    }
    @PutMapping("/products/{id}")
    public products updateProducts(@PathVariable(value = "id") Long noteId,
                                  @Valid @RequestBody products noteDetails) {

        products note = productRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));

        note.setSrc(noteDetails.getSrc());


        products updatedNote = productRepository.save(note);
        return updatedNote;
    }
    @PutMapping("/product/{id}")
    public products updateProduct(@PathVariable(value = "id") Long noteId,
                                   @Valid @RequestBody products noteDetails) {

        products note = productRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));

        note.setName(noteDetails.getName());


        products updatedNote = productRepository.save(note);
        return updatedNote;
    }
    @GetMapping("/products/{category}")
    public List<products> getProductByCategory(@PathVariable(value="category")String category)
    {
        return productRepository.findAllByCategory(category);
    }
    @GetMapping("/product/{price}")
    public List<products> getProductByPrice(@PathVariable(value="price")Double price)
    {
        return productRepository.findAllByPrice(price);
    }
    @GetMapping("/products/{category}/{price1}/{price2}")
    public List<products> getProductByPrice(@PathVariable(value="category")String c,@PathVariable(value="price1")double p,@PathVariable(value="price2")double p2)
    {
        return productRepository.findByCategoryAndPriceBetween(c,p,p2);
    }
    @GetMapping("/products/{price1}/between/{price2}")
    public List<products> getProductByPriceBtw(@PathVariable(value="price1")double p,@PathVariable(value="price2")double p2)
    {
        return productRepository.findAllByPriceBetween(p,p2);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        products note = productRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFound("Note", "id", noteId));
        productRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
