package com.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "demo", type = "post", refreshInterval = "-1")
public class Post {

    @Id
    private String id;

    private String title;

    private String content;

    private Integer userId;

    private Integer weight;

    @Override public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", weight=" + weight +
                '}';
    }

}
