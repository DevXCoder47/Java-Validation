package com.nikijv.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.nikijv.validation.annotation.*;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @NotNull
    private Optional<Integer> id;

    @NotEmpty
    private String text;

    @NotNull
    private Optional<Integer> userId;

    @NotNull
    private Optional<Integer> postId;
}
