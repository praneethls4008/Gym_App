package com.example.spring1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Document(collection="videos")
@Accessors(fluent = true,chain = true)
@Data
public class Video {
    @Id
    private String id;


    @Indexed(unique = true)
    @JsonProperty("url")
    private String url;

    @Indexed(unique = false)
    @JsonProperty("ownerID")
    private String ownerID;

    @JsonProperty("isPrivate")
    private boolean isPrivate;

    @JsonProperty("privateViewers")
    private List<String> privateViewers;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("uploadDate")
    private Date uploadDate;
}
