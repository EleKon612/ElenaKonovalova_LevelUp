package ru.levelp.at.lesson0809.api;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CreatePostsRequestData {

    @JsonProperty("user_id")
    private Integer userId;

    private String title;
    private String body;

    //@JsonProperty("user_id")
    //private UserId userId;
}
