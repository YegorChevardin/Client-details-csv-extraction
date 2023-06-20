package com.test.task.yegorchevardin.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class that represents file path
 * as dto
 * @author yegorchevardin
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class FilePathDto {
    @NotNull(message = "File path should not be null")
    private String filePath;
}
