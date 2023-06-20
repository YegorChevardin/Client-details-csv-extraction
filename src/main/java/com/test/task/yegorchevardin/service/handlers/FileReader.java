package com.test.task.yegorchevardin.service.handlers;

import java.util.List;

/**
 * Interface for file reader
 * that defines methods for reading files
 * @author yegorchevardin
 * @version 0.0.1
 */
public interface FileReader {
    List<String> readLines(String pathToResource);
}
