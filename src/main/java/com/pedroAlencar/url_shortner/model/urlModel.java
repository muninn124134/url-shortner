package com.pedroAlencar.url_shortner.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "url")
public class urlModel {

    private String longUrl;
    private String shortUrl;
    
}
