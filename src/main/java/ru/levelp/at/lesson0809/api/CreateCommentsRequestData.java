package ru.levelp.at.lesson0809.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentsRequestData {

    private Integer post_id;
    private String name;
    private String email;
    private String body;
}
