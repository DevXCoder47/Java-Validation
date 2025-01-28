package com.nikijv.validation.entity;

import com.nikijv.validation.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @NotNull
    private Optional<Integer> id;

    @NotEmpty
    private String media;

    @NotEmpty
    private String description;

    @NotNull
    private Optional<Integer> userId;
}
