package com.test.task.yegorchevardin.service.services.impl;

import com.test.task.yegorchevardin.service.dto.ClientDto;
import com.test.task.yegorchevardin.service.dto.EmailDto;
import com.test.task.yegorchevardin.service.dto.FilePathDto;
import com.test.task.yegorchevardin.service.services.CsvFormService;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.Table;

@Service
@RequiredArgsConstructor
public class CsvFormServiceImpl implements CsvFormService {
    private final ObjectFileExtractor<ClientDto> clientDtoObjectFileExtractor;
    private final ObjectFileExtractor<EmailDto> emailDtoObjectFileExtractor;
    private final ObjectFileExtractor<FilePathDto> filePathDtoObjectFileExtractor;

    @Override
    public Table showResult() {
        return null;//todo
    }
}
