package com.test.task.yegorchevardin.service.dto;

import lombok.Data;

/**
 * Class that represents client as dto
 * @author yegorchevardin
 * @version 0.0.1
 */
@Data
public class ClientDto {
    private static final String SPLIT_REGEX = "\\s";

    private String name;
    private String secondName;
    private String fullInitials;

    private ClientDto(String name, String secondName, String fullInitials) {
        this.name = name;
        this.secondName = secondName;
        this.fullInitials = fullInitials;
    }

    public static ClientDto createClientDto(String fullInitials) {
        String[] initials = fullInitials.split(SPLIT_REGEX);

        String name = initials[0];
        String secondName = initials[1];
        if (initials.length > 2) {
            secondName = secondName + " " + initials[2];
        }

        return new ClientDto(name, secondName, fullInitials);
    }
}
