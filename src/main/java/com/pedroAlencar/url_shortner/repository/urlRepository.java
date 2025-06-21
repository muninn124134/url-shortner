package com.pedroAlencar.url_shortner.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedroAlencar.url_shortner.model.urlModel;

public interface urlRepository extends MongoRepository<urlModel, String> {
    
    public java.util.Optional<urlModel> findByShortUrl(String shortUrl);
    
}
