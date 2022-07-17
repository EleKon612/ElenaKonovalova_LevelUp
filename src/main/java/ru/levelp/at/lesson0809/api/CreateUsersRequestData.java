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
public class CreateUsersRequestData {

    private String name;
    private String gender;
    private String email;
    private String status;
}
