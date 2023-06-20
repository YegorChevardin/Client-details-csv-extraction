package com.test.task.yegorchevardin.service.services.impl;

import com.test.task.yegorchevardin.service.dto.FilePathDto;
import com.test.task.yegorchevardin.service.handlers.FileReader;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileDtoExtractor implements ObjectFileExtractor<FilePathDto> {
    private static final String PATH_TO_CLIENT_FILES = "classpath:static/List_of_files.txt";
    private final FileReader fileReader;

    @Override
    public List<FilePathDto> getObjects() {
        List<String> lines = fileReader.readLines(PATH_TO_CLIENT_FILES);
        return lines.stream().map(
                FilePathDto::new
        ).collect(Collectors.toList());
    }
}
