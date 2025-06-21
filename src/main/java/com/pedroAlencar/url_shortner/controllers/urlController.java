package com.pedroAlencar.url_shortner.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pedroAlencar.url_shortner.services.urlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping
public class urlController {

    @Autowired
    private urlService urlService;
    
    @PostMapping
    public String postMethodName(@RequestBody String entity) {
        String response = urlService.createShortUrl(entity);
        return response;
    }
    
    
}
