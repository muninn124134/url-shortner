package com.pedroAlencar.url_shortner.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pedroAlencar.url_shortner.model.urlModel;
import com.pedroAlencar.url_shortner.repository.urlRepository;
import com.pedroAlencar.url_shortner.services.urlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping
public class urlController {

    @Autowired
    private urlService urlService;

    @Autowired
    private urlRepository urlRepository;
    
    @PostMapping("/create-url{longUrl}")
    public String createShortUrl(@RequestParam String longUrl) {
        String shortUrl = urlService.createShortUrl(longUrl);
        
        urlModel url = new urlModel(longUrl, shortUrl);
        urlRepository.save(url);
        
        return shortUrl;
    }

    @GetMapping("/get-url{shortUrl}")
    public String getLongUrl(@RequestParam String shortUrl) {
        
        String longUrl = urlService.getLongUrl(shortUrl);

        return longUrl;
    }

    @GetMapping
    public String listAllUrl() {
        StringBuilder response = new StringBuilder();
        for (urlModel url : urlRepository.findAll()) {
            response.append("Long URL: ").append(url.getLongUrl())
                    .append(", Short URL: ").append(url.getShortUrl())
                    .append("\n");
        }
        return response.toString();
    }
    
    @DeleteMapping("delete-by-longurl{longUrl}")
    public String deleteByLongUrl(@RequestParam String longUrl) {
        urlRepository.deleteByLongUrl(longUrl);
        return "URL deleted successfully: " + longUrl;
    }

    @DeleteMapping("delete-by-shorturl{shortUrl}")
    public String deleteByShortUrl(@RequestParam String shortUrl) {
        urlRepository.deleteByShortUrl(shortUrl);
        return "URL deleted successfully: " + shortUrl;
    }
    
    
    
}
