package com.pedroAlencar.url_shortner.services;

import org.springframework.stereotype.Service;

import com.pedroAlencar.url_shortner.model.urlModel;
import com.pedroAlencar.url_shortner.repository.urlRepository;

@Service
public class urlService {

    private final urlRepository urlRepository;

    public urlService(urlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String createShortUrl(String longUrl) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String shortUrl = "";
        
        for (int i = 0; i < 6; i++) {
            int randomIndex = (int) (Math.random() * chars.length());
            char randomChar = chars.charAt(randomIndex);
            shortUrl += randomChar;
        }

        return "http://short.url/" + shortUrl;
    }
    
    public String getLongUrl(String shortUrl) throws RuntimeException {
        urlModel url = null;
        try {
            url = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
        } catch (RuntimeException e) {
            System.err.println("Error retrieving long URL for short URL: " + shortUrl);
            e.printStackTrace();
            throw e;
        }
        return url.getLongUrl();
    }
    
}
