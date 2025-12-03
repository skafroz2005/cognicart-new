package com.cognicart.inventoryservice.controller;

import com.cognicart.inventoryservice.dto.InventoryResponse;
import com.cognicart.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    //http://localhost:8082/api/inventory/iphone_14,iphone_14_red

    //http://localhost:8082/api/inventory?skuCode=iphone_14&skuCode=iphone_14_red
    // We are using @RequestParam for multiple skuCodes

    // @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

    //     return inventoryService.isInStock(skuCode);
    // }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode){
        return inventoryService.isInStock(skuCode);
    }

}
