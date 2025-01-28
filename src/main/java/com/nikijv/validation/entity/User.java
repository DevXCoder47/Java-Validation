package com.nikijv.validation.entity;

import com.nikijv.validation.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private Optional<Integer> id;

    @NotEmpty @Pattern
    private String firstName;

    @NotEmpty @Pattern
    private String lastName;

    @Size (min = 6, max = 60) @Min (min = 6) @Max (max = 60)
    private int age;

    @Future
    private LocalDate tokenExpirationDateTime;

    @NotEmpty @Email
    private String email;

    private String password;

}
