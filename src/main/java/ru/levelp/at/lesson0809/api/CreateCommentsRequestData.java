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
public class CreateCommentsRequestData {

    @JsonProperty("post_id")
    private Integer postId;

    private String name;
    private String email;
    private String body;

    //@JsonProperty("post_id")
    //private PostId postId;
}
