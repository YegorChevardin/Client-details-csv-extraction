package com.test.task.yegorchevardin.controllers;

import com.test.task.yegorchevardin.service.dto.EmailDto;
import com.test.task.yegorchevardin.service.dto.FilePathDto;
import com.test.task.yegorchevardin.service.services.CsvFormService;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.tablesaw.api.Table;
import java.io.IOException;

/**
 * Controller for handling requests with files
 * @author yegorchevardin
 * @version 0.0.1
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FileController {
    private final CsvFormService csvFormService;

    /**
     * Controller for getting ready file with clients
     */
    @PostMapping("/clients")
    public void showClients(
            HttpServletResponse response
    ) throws IOException {
        response.setContentType("text/csv; charset=utf-8");
        Table table = csvFormService.showResult();
        table.write().csv(response.getWriter());
    }
}
