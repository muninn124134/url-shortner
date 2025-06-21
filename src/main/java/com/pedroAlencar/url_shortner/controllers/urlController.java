package com.pedroAlencar.url_shortner.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pedroAlencar.url_shortner.model.urlModel;
import com.pedroAlencar.url_shortner.repository.urlRepository;
import com.pedroAlencar.url_shortner.services.urlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping
public class urlController {

    @Autowired
    private urlService urlService;

    @Autowired
    private urlRepository urlRepository;
    
    @PostMapping
    public String createShortUrl(@RequestBody String longUrl) {
        String shortUrl = urlService.getLongUrl(longUrl);
        urlModel url = new urlModel(longUrl, shortUrl);

        urlRepository.save(url);
        
        return shortUrl;
    }

    @GetMapping
    public String getLongUrl(@RequestBody String shortUrl) {
        
        urlModel url = urlRepository.findByShortUrl(shortUrl)
            .orElseThrow(() -> new RuntimeException("Short URL not found"));

        return url.getLongUrl();
    }
    
    
    
}
