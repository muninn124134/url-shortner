package com.pedroAlencar.url_shortner.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pedroAlencar.url_shortner.model.urlModel;

public interface urlRepository extends MongoRepository<urlModel, String> {
    Optional<urlModel> findByShortUrl(String shortUrl);

    Optional<urlModel> findByLongUrl(String LongUrl);

    void deleteByShortUrl(String shortUrl);

    void deleteByLongUrl(String longUrl);
}
