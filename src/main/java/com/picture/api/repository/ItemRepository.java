package com.picture.api.repository;

import com.picture.api.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i ORDER BY RANDOM()")
    List<Item> findRandomItems(@Param("limit") int limit);
}
