package com.test.task.yegorchevardin.service.handlers.impl;

import com.test.task.yegorchevardin.service.exceptions.FileReadException;
import com.test.task.yegorchevardin.service.handlers.FileReader;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FileReaderImpl implements FileReader {
    private final ResourceLoader resourceLoader;

    @Override
    public List<String> readLines(String pathToResource) {
        List<String> lines = new ArrayList<>();

        Resource resource = resourceLoader.getResource(pathToResource);

        try (
                InputStream fileInputStream = resource.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        fileInputStream, StandardCharsets.UTF_8
                ))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new FileReadException(
                    "Cannot read source file: " + pathToResource,
                    e
            );
        }

        return lines;
    }
}
