package com.picture.api.service;

import com.picture.api.model.Item;
import com.picture.api.model.dto.CreateItemRequest;
import com.picture.api.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void createItem(CreateItemRequest createItemRequest) {
        Item item = new Item();
        item.setTitle(createItemRequest.getTitle());
        item.setDescription(createItemRequest.getDescription());
        item.setPictureUrl(createItemRequest.getPictureUrl());
        itemRepository.save(item);
    }

    public Long countItems() {
        return itemRepository.countItems();
    }

    public Item getRandomItem() {
        List<Item> items = itemRepository.findRandomItems(1);
        if (!items.isEmpty()) {
            return items.get(0);
        }
        return null;
    }
}
