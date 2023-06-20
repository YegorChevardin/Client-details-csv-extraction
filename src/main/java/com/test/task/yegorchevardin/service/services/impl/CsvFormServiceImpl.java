package com.test.task.yegorchevardin.service.services.impl;

import com.test.task.yegorchevardin.service.dto.ClientDto;
import com.test.task.yegorchevardin.service.dto.EmailDto;
import com.test.task.yegorchevardin.service.dto.FilePathDto;
import com.test.task.yegorchevardin.service.services.CsvFormService;
import com.test.task.yegorchevardin.service.services.ObjectFileExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CsvFormServiceImpl implements CsvFormService {
    private static final String WORDS_DELIMITER = "";

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
        prepareEmailData(emailColumn, clientDtos, emailDtos);

        System.out.println();

        StringColumn filePathColumn = StringColumn.create("Client files");
        prepareFilePathData(filePathColumn, clientDtos, filePathDtos);

        table.addColumns(nameColumn, emailColumn, filePathColumn);

        System.out.println(table.print());
        return table;
    }

    private void prepareEmailData(StringColumn column, List<ClientDto> clientDtos, List<EmailDto> emailDtos) {
        for (ClientDto client : clientDtos) {
            String name = client.getName();
            String nameFirstLetter = String.valueOf(name.charAt(0));
            String preparedEmailPrefix = "dundermifflin\\.[A-Za-z]{2,}";
            String preParedSecondName = client.getSecondName().replace(" ", "").replace(".",
                    "\\.");
            String regexPatternFullName = "^" + name + "[._]?" + preParedSecondName + "@" + preparedEmailPrefix;
            String regexPatternOneLetterName = "^" + nameFirstLetter + "[._]?" + preParedSecondName + "@" + preparedEmailPrefix;

            String clientEmail = null;
            for (EmailDto emailDto : emailDtos) {
                String currentValue = emailDto.getEmail();
                if (currentValue.matches(regexPatternFullName) || currentValue.matches(regexPatternOneLetterName)) {
                    clientEmail = currentValue;
                    break;
                }
            }
            if (clientEmail != null) {
                column.append(clientEmail);
            } else {
                column.appendMissing();
            }
        }
    }

    private void prepareFilePathData(StringColumn column, List<ClientDto> clientDtos, List<FilePathDto> filePathDtos) {
        for (ClientDto client : clientDtos) {
            String name = client.getName();
            String nameFirstLetter = String.valueOf(name.charAt(0));
            String preParedSecondName = client.getSecondName().replace(" ", "").replace(".",
                    "\\.");
            String regexPatternFullName = ".*" + name + "[._\\s]?" + preParedSecondName + "\\.[A-Za-z]{2,}";
            String regexPatternOneLetterName = ".*" + nameFirstLetter + "[._\\s]?" + preParedSecondName + "\\.[A-Za-z]{2,}";

            String clientPath = null;
            for (FilePathDto filePathDto : filePathDtos) {
                String currentValue = filePathDto.getFilePath();
                if (currentValue.matches(regexPatternFullName) || currentValue.matches(regexPatternOneLetterName)) {
                    clientPath = currentValue;
                    break;
                }
            }
            if (clientPath != null) {
                column.append(clientPath);
            } else {
                column.appendMissing();
            }
        }
    }
}
