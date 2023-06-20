package com.test.task.yegorchevardin.service.services.impl;

import com.test.task.yegorchevardin.service.dto.EmailDto;
import com.test.task.yegorchevardin.service.handlers.FileReader;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmailFileExtractor implements ObjectFileExtractor<EmailDto> {
    private static final String PATH_TO_EMAIL_FILE = "classpath:static/List of e-mails.txt";
    private final FileReader fileReader;

    @Override
    public List<EmailDto> getObjects() {
        List<String> lines = fileReader.readLines(PATH_TO_EMAIL_FILE);
        return lines.stream().map(
                EmailDto::new
        ).collect(Collectors.toList());
    }
}
