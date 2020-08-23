package com.ankur.eureka.controller;


import com.ankur.eureka.domain.*;
import com.ankur.eureka.domain.Info;
import com.ankur.eureka.service.InventoryService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static java.net.HttpURLConnection.*;


@RestController
@RequestMapping("/inventory/services")
@Api(value = "/inventory/services", tags = ("Inventory Management"))
@CrossOrigin(allowedHeaders = "*",maxAge = 3600)
public class InventoryController {

    private static final String CLIENT_ID = "client-id";
    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @RequestMapping(value = "findById", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "findById", notes = "Find a single inventory item by id", nickname = "findById")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Missing / invalid parameter", response = ServiceErrorResponse.class),
            @ApiResponse(code = 200, message = "Success", response = InventoryFindByIdResponse.class)})
    public ResponseEntity<?> postWithRequestBody(@RequestHeader(value = CLIENT_ID) String clientId,
                                                 @Valid @RequestBody InventoryFindByIdRequest request) {
        return inventoryService.findById(request);
    }

    @RequestMapping(value = "all", method = {RequestMethod.GET}, produces = "application/json")
    @ApiOperation(value = "all", notes = "Get all inventory items", nickname = "all")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Missing / invalid parameter", response = ServiceErrorResponse.class),
            @ApiResponse(code = 200, message = "Success", response = InventoryListAllResponse.class)})
    public ResponseEntity<?> getWithoutAnyRequestParamOrPathVariable(@RequestHeader(value = CLIENT_ID) String clientId
    ) {
        return inventoryService.all();
    }


}

