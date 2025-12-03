package com.cognicart.productservice.controller;

import com.cognicart.productservice.dto.ProductRequest;
import com.cognicart.productservice.dto.ProductResponse;
import com.cognicart.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    final private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return "Product saved succesfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    // @GetMapping("/category")            //week3 day3
    // public List<ProductResponse> filterByCategory(@RequestParam String category) {
    //     return productService.filterByCategory(category);
    // }
}
