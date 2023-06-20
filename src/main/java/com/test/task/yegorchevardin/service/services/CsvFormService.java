package com.test.task.yegorchevardin.service.services;

import tech.tablesaw.api.Table;

/**
 * Interface for defining methods for
 * extracting ready csv file from the static content
 * @author yegorchevardin
 * @version 0.0.1
 */
public interface CsvFormService {
    /**
     * Method for getting ready result
     */
    Table showResult();
}
