package com.example.spring1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;

@Document(collection="videos")
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

    public Video(String id, String url, String ownerID, boolean isPrivate, List<String> privateViewers, String title, String description, Date uploadDate) {
        this.id = id;
        this.url = url;
        this.ownerID = ownerID;
        this.isPrivate = isPrivate;
        this.privateViewers = privateViewers;
        this.title = title;
        this.description = description;
        this.uploadDate = uploadDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public List<String> getPrivateViewers() {
        return privateViewers;
    }

    public void setPrivateViewers(List<String> privateViewers) {
        this.privateViewers = privateViewers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", ownerID='" + ownerID + '\'' +
                ", isPrivate=" + isPrivate +
                ", privateViewers=" + privateViewers +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
