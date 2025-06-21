package com.pedroAlencar.url_shortner.services;

import org.springframework.stereotype.Service;

import com.pedroAlencar.url_shortner.model.urlModel;

@Service
public class urlService {

    public String createShortUrl(urlModel urlModel) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String shortUrl = "";
        
        for (int i = 0; i < 6; i++) {
            int randomIndex = (int) (Math.random() * chars.length());
            char randomChar = chars.charAt(randomIndex);
            shortUrl += randomChar;
        }

        return shortUrl;
    }
    
    public String getLongUrl(String shortUrl) {
        // Here you would implement the logic to retrieve the long URL from the short URL
        // For now, we will just return a dummy long URL
        return "http://long.url/" + shortUrl.hashCode();
    }
    
}
