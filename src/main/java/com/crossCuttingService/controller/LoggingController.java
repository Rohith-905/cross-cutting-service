package com.crossCuttingService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossCuttingService.Entity.LogRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/crossCutting")
@RestController
public class LoggingController {
	
    private static final Logger logger = LoggerFactory.getLogger(LoggingController.class);
    

    @Operation(summary = "Log a message with a specified level")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Log message successfully processed"),
        @ApiResponse(responseCode = "400", description = "Invalid log level or request body"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/log")
    public void logMessage(@RequestBody LogRequest logRequest) {
    	switch(logRequest.getLevel()) {
    	case "INFO" :
    		logger.info(logRequest.getMessage());
    		break;
    	case "ERROR" :
    		logger.error(logRequest.getMessage());
    		break;
    	case "DEBUG" :
    		logger.debug(logRequest.getMessage());
    		break;
    	default:
    		logger.info(logRequest.getMessage());
    	}
    	
    }
    

}
