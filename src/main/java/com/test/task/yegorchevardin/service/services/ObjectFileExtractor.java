package com.test.task.yegorchevardin.service.services;

import java.util.List;

/**
 * Interface for extracting dto objects
 * from file
 * @author yegorchevardin
 * @version 0.0.1
 */
public interface ObjectFileExtractor<T> {
    /**
     * Method for extracting object from lines
     */
    List<T> getObjects();
}
