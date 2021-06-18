package com.demoshop.demoshop.simple;

import com.demoshop.demoshop.data.dto.simple.SimplePetDto;
import com.demoshop.demoshop.service.api.SimplePetService;
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
class SimplePetServiceTest {

    @Autowired
    private SimplePetService simplePetService;

    @DisplayName("Проверка SimplePetService")
    @Test
    @Transactional
    void getAllPetList() {
        List<SimplePetDto> list = simplePetService.findAllPets();
        assertNotNull(list, "Список пустой");
    }

}
