package com.picture.api.controller;

import com.picture.api.model.Item;
import com.picture.api.model.dto.CreateItemRequest;
import com.picture.api.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/random")
    public Item getRandomItem() {
        return itemService.getRandomItem();
    }

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody CreateItemRequest createItemRequest) {
        itemService.createItem(createItemRequest);
        return ResponseEntity.ok().build();
    }
}
