package ru.levelp.at.lesson0809.api;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequestData {

    private String name;
    private String gender;
    private String email;
    private String status;
}
