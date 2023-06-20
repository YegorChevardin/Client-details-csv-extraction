package com.test.task.yegorchevardin.service.services.impl;

import com.test.task.yegorchevardin.service.dto.ClientDto;
import com.test.task.yegorchevardin.service.dto.EmailDto;
import com.test.task.yegorchevardin.service.dto.FilePathDto;
import com.test.task.yegorchevardin.service.services.CsvFormService;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CsvFormServiceImpl implements CsvFormService {
    private final ObjectFileExtractor<ClientDto> clientDtoObjectFileExtractor;
    private final ObjectFileExtractor<EmailDto> emailDtoObjectFileExtractor;
    private final ObjectFileExtractor<FilePathDto> filePathDtoObjectFileExtractor;

    @Override
    public Table showResult() {
        List<ClientDto> clientDtos = clientDtoObjectFileExtractor.getObjects();
        List<EmailDto> emailDtos = emailDtoObjectFileExtractor.getObjects();
        List<FilePathDto> filePathDtos = filePathDtoObjectFileExtractor.getObjects();
        Table table = Table.create("Result");

        StringColumn nameColumn = StringColumn.create("Client initials");
        nameColumn.addAll(clientDtos.stream().map(
                ClientDto::getFullInitials
        ).collect(Collectors.toList()));

        StringColumn emailColumn = StringColumn.create("Client emails");
        prepareEmailData(emailColumn, emailDtos);

        StringColumn filePathColumn = StringColumn.create("Client files");
        prepareFilePathData(filePathColumn, filePathDtos);

        return table;
    }

    private void prepareEmailData(StringColumn column, List<EmailDto> emailDtos) {
        //todo
    }

    private void prepareFilePathData(StringColumn column, List<FilePathDto> filePathDtos) {
        //todo
    }
}
