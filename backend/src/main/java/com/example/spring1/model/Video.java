package com.example.spring1.model;

import lombok.Data;
import lombok.experimental.Accessors;
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
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @Indexed(unique = true)
    private String url;
    @Indexed(unique = false)
    private String ownerID;
    private boolean isPrivate;
    private List<String> privateViewers;
    private String title;
    private String description;
    private Date uploadDate;
}
