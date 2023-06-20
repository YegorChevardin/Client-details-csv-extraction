package com.test.task.yegorchevardin.service.services.impl;

import com.test.task.yegorchevardin.service.dto.ClientDto;
import com.test.task.yegorchevardin.service.handlers.FileReader;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientFileExtractor implements ObjectFileExtractor<ClientDto> {
    private static final String CLASSPATH_TO_NAME_FILE = "classpath:static/Users names.txt";
    private final FileReader fileReader;

    @Override
    public List<ClientDto> getObjects() {
        List<String> lines = fileReader.readLines(CLASSPATH_TO_NAME_FILE);

        return lines.stream().map(
                ClientDto::createClientDto
        ).collect(Collectors.toList());
    }
}
