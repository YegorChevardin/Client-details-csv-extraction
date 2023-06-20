package com.test.task.yegorchevardin.controllers;

import com.test.task.yegorchevardin.service.dto.ClientDto;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling requests with files
 * @author yegorchevardin
 * @version 0.0.1
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FileController {
    private final ObjectFileExtractor<ClientDto> fileExtractor;

    /**
     * Controller for getting ready file with clients
     */
    @PostMapping("/clients")
    public ResponseEntity<List<ClientDto>> showClients() {
        return ResponseEntity.ok(fileExtractor.getObjects());
    }
}
