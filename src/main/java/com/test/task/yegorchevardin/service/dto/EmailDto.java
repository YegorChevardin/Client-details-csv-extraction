package com.test.task.yegorchevardin.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class that represents email as dto
 * @author yegorchevardin
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
public class EmailDto {
    @Email(message = "Email should be valid")
    @NotNull(message = "Email should not be null")
    private String email;
}
