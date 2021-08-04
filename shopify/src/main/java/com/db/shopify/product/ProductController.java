package com.db.shopify.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceContract productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> getByCode(@PathVariable("code") String code){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getByCode(code));
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insertProduct(product));
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws IllegalAccessException, CloneNotSupportedException {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(product));
    }

    @DeleteMapping
    public ResponseEntity<Product> deleteProduct(@RequestParam("code") String code){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProductByCode(code));
    }
}