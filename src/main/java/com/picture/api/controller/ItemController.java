package com.picture.api.controller;

import com.picture.api.model.Item;
import com.picture.api.model.dto.CreateItemRequest;
import com.picture.api.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/count")
    public Long countItems() {
        return itemService.countItems();
    }

    @GetMapping("/random")
    public Item getRandomItem() {
        return itemService.getRandomItem();
    }

    @PostMapping
    public ResponseEntity<?> createItem(CreateItemRequest createItemRequest) {
        itemService.createItem(createItemRequest);
        return ResponseEntity.ok().build();
    }
}
