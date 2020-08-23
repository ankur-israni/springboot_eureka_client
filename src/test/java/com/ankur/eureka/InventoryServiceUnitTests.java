package com.ankur.eureka;


import com.ankur.eureka.domain.*;
import com.ankur.eureka.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryServiceUnitTests {

    private InventoryService inventoryService;

    @Test
    public void findById() {
        InventoryService service = new InventoryService();
        ResponseEntity<InventoryFindByIdResponse> response = (ResponseEntity<InventoryFindByIdResponse>) service.findById(new InventoryFindByIdRequest(1));
        assertEquals("Laptop",response.getBody().getItem().getName());
    }




}
