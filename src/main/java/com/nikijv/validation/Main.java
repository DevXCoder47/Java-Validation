package com.nikijv.validation;

import com.nikijv.validation.entity.Comment;
import com.nikijv.validation.entity.Post;
import com.nikijv.validation.entity.User;
import com.nikijv.validation.validator.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Validator validator = new Validator(Arrays.asList(
                new User (
                        null,
                        "Bob",
                        "Sparrow64",
                        61,
                        LocalDate.of(2024, 02, 25),
                        " ",
                        "jrndrfgrd43"
                ),
                new Post (
                        null,
                        "",
                        "",
                        null
                ),
                new Comment (
                        Optional.of(4),
                        "",
                        null,
                        null
                )
        ));
        validator.validateEntities();
    }
}
