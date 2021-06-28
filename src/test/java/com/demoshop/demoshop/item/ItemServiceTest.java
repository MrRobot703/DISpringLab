package com.demoshop.demoshop.item;

import com.demoshop.demoshop.data.dto.simple.ItemDto;
import com.demoshop.demoshop.service.api.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @DisplayName("Check ItemService")
    @Test
    @Transactional
    void getAllItems() {
        List<ItemDto> list = itemService.getAllItems();
        assertNotNull(list, "Empty list");
    }

}
